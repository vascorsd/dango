import mill._
import scalalib._
import scalafmt._
import $ivy.`com.lihaoyi::mill-contrib-bsp:0.6.1`
import $ivy.`com.lihaoyi::mill-contrib-bloop:0.6.1`

object Dependencies {

  object zio {
    val version = "1.0.0-RC18-2"
    val catsInteropVersion = "2.0.0.0-RC12"

    def libs = {
      Agg(
        ivy"dev.zio::zio:$version",
        ivy"dev.zio::zio-streams:$version",
        ivy"dev.zio::zio-interop-cats:$catsInteropVersion",
      )
    }
  }

  object sttp {
    val version = "2.0.5"

    def libs = {
      Agg(
        ivy"com.softwaremill.sttp.client::core:$version",
      )
    }
  }

  object caliban {
    val version = "0.7.0"

    def libs = {
      Agg(
        ivy"com.github.ghostdogpr::caliban:$version",
        ivy"com.github.ghostdogpr::caliban-client:$version",
      )
    }

    /*def libs_gen = {
      Agg(
        ivy"com.github.ghostdogpr::caliban-codegen:$version",
      )
    }*/
  }
}

trait DangoModule extends ScalaModule with ScalafmtModule {
  def scalaVersion = {
    "2.13.1"
  }

  // I can't understand what or how this is different than the below one.
  // tried acyclic plugin but didn't report anything when tried, so no idea...
  /*def compileIvyDeps = Agg(
  )*/

  def scalacPluginIvyDeps = Agg(
    ivy"org.scalameta:::semanticdb-scalac:4.3.0",
    ivy"io.tryp:::splain:0.5.1",
    ivy"org.typelevel:::kind-projector:0.11.0",
    ivy"com.olegpy::better-monadic-for:0.3.1",
  )

  def scalacOptions = {
    Seq(
      "-encoding",
      "UTF-8",
      "-unchecked",
      "-deprecation",
      "-feature",
      "-explaintypes",

      "-Ywarn-numeric-widen",
      "-Yrangepos",
      "-Ywarn-unused:imports",
      "-Ywarn-value-discard",
      "-Ywarn-dead-code",

      "-Xlint:adapted-args",
      "-Xlint:infer-any",
      "-Xlint:missing-interpolator",
      "-Xlint:private-shadow",
      "-Xlint:type-parameter-shadow",

    )
  }

  object test extends Tests {
    def ivyDeps = Agg(ivy"com.lihaoyi::utest:0.7.1")
    def testFrameworks = Seq("utest.runner.Framework")
  }
}

object bin extends Module {
  object client extends DangoModule {
    def moduleDeps = {
      Seq(lib.core)
    }
  }
}


import $ivy.`com.github.ghostdogpr::caliban:0.7.0`
import $ivy.`dev.zio::zio:1.0.0-RC18-2`

object lib extends Module {
  object core extends DangoModule {
    def ivyDeps = {
      Dependencies.zio.libs ++
        Dependencies.caliban.libs ++
        Dependencies.sttp.libs
    }
  }

  object api_gitlab extends DangoModule with CalibanCodegenModule {
    def ivyDeps = {
      Dependencies.zio.libs ++
        Dependencies.caliban.libs
    }
  }

  object api_github extends DangoModule with CalibanCodegenModule {
    def ivyDeps = {
      Dependencies.zio.libs ++
        Dependencies.caliban.libs
    }
  }
}

trait CalibanCodegenModule extends ScalaModule {
  def schema = {
    millSourcePath / "resources" / "schema.graphql"
  }

  def output = {
    millSourcePath / "src" / "generated.scala"
  }

  object SchemaWriter {
    import caliban.parsing.adt.Definition.TypeSystemDefinition.TypeDefinition._
    import caliban.parsing.adt.Type.{ ListType, NamedType }
    import caliban.parsing.adt.{ Document, Type }

    def write(schema: Document, objectName: String = "", packageName: Option[String] = None): String = {
      val schemaDef = Document.schemaDefinitions(schema).headOption

      val argsTypes = Document
        .objectTypeDefinitions(schema)
        .flatMap(_.fields.filter(_.args.nonEmpty).map(writeArguments))
        .mkString("\n")

      val unionTypes = Document
        .unionTypeDefinitions(schema)
        .map(union => (union, union.memberTypes.flatMap(Document.objectTypeDefinition(schema, _))))
        .toMap

      val unions = unionTypes.map { case (union, objects) => writeUnion(union, objects) }.mkString("\n")

      val objects = Document
        .objectTypeDefinitions(schema)
        .filterNot(obj =>
                     reservedType(obj) ||
                       schemaDef.exists(_.query.getOrElse("Query") == obj.name) ||
                       schemaDef.exists(_.mutation.getOrElse("Mutation") == obj.name) ||
                       schemaDef.exists(_.subscription.getOrElse("Subscription") == obj.name) ||
                       unionTypes.values.flatten.exists(_.name == obj.name)
                   )
        .map(writeObject)
        .mkString("\n")

      val inputs = Document.inputObjectTypeDefinitions(schema).map(writeInputObject).mkString("\n")

      val enums = Document.enumTypeDefinitions(schema).map(writeEnum).mkString("\n")

      val queries = Document
        .objectTypeDefinition(schema, schemaDef.flatMap(_.query).getOrElse("Query"))
        .map(t => writeRootQueryOrMutationDef(t))
        .getOrElse("")

      val mutations = Document
        .objectTypeDefinition(schema, schemaDef.flatMap(_.mutation).getOrElse("Mutation"))
        .map(t => writeRootQueryOrMutationDef(t))
        .getOrElse("")

      val subscriptions = Document
        .objectTypeDefinition(schema, schemaDef.flatMap(_.subscription).getOrElse("Subscription"))
        .map(t => writeRootSubscriptionDef(t))
        .getOrElse("")

      val hasSubscriptions = subscriptions.nonEmpty
      val hasTypes         = argsTypes.length + objects.length + enums.length + unions.length + inputs.length > 0
      val hasOperations    = queries.length + mutations.length + subscriptions.length > 0

      val typesAndOperations = s"""
      ${if (hasTypes)
        "object Types {\n" +
          argsTypes + "\n" +
          objects + "\n" +
          inputs + "\n" +
          unions + "\n" +
          enums + "\n" +
          "\n}\n"
      else ""}

      ${if (hasOperations)
        "object Operations {\n" +
          queries + "\n\n" +
          mutations + "\n\n" +
          subscriptions + "\n" +
          "\n}"
      else ""}
      """

      s"""${packageName.fold("")(p => s"package $p\n\n")}${if (hasTypes && hasOperations) "import Types._\n" else ""}
          ${if (typesAndOperations.contains("@GQL")) "import caliban.schema.Annotations._\n" else ""}
          ${if (hasSubscriptions) "import zio.stream.ZStream" else ""}

      $typesAndOperations
      """
    }

    def protectedReservedName(name: String): String = {
      val reserved = "package" :: "object" :: "private" :: "type" :: Nil
      if (reserved.contains(name)) s"`${name}`" else name
    }

    def reservedType(typeDefinition: ObjectTypeDefinition): Boolean =
      typeDefinition.name == "Query" || typeDefinition.name == "Mutation" || typeDefinition.name == "Subscription"

    def writeRootField(field: FieldDefinition): String = {
      val argsName = if (field.args.nonEmpty) s"${field.name.capitalize}Args" else "()"

      s"${protectedReservedName(field.name)}: $argsName => ${writeType(field.ofType)}"
    }

    def writeRootQueryOrMutationDef(op: ObjectTypeDefinition): String =
      s"""
         |${writeDescription(op.description)}case class ${op.name}(
         |${op.fields.map(c => writeRootField(c)).mkString(",\n")}
         |)""".stripMargin

    def writeSubscriptionField(field: FieldDefinition): String =
      "%s: %s => ZStream[Any, Nothing, %s]".format(
        if (field.name == "type") s"`${field.name}`" else field.name,
        if (field.args.nonEmpty) s"${field.name.capitalize}Args" else "()",
        writeType(field.ofType)
        )

    def writeRootSubscriptionDef(op: ObjectTypeDefinition): String =
      s"""
         |${writeDescription(op.description)}case class ${op.name}(
         |${op.fields.map(c => writeSubscriptionField(c)).mkString(",\n")}
         |)""".stripMargin

    def writeObject(typedef: ObjectTypeDefinition): String =
      s"""${writeDescription(typedef.description)}case class ${typedef.name}(${typedef.fields
        .map(writeField(_, typedef))
        .mkString(", ")})"""

    def writeInputObject(typedef: InputObjectTypeDefinition): String =
      s"""${writeDescription(typedef.description)}case class ${typedef.name}(${typedef.fields
        .map(writeInputValue(_, typedef))
        .mkString(", ")})"""


    def writeEnum(typedef: EnumTypeDefinition): String =
      s"""${writeDescription(typedef.description)}sealed trait ${typedef.name} extends scala.Product with scala.Serializable

          object ${typedef.name} {
            ${typedef.enumValuesDefinition
        .map(v => s"${writeDescription(v.description)}case object ${protectedReservedName(v.enumValue)} extends ${typedef.name}")
        .mkString("\n")}
          }
       """

    def writeUnion(typedef: UnionTypeDefinition, objects: List[ObjectTypeDefinition]): String =
      s"""${writeDescription(typedef.description)}sealed trait ${typedef.name} extends scala.Product with scala.Serializable

          object ${typedef.name} {
            ${objects
        .map(o => s"${writeObject(o)} extends ${typedef.name}")
        .mkString("\n")}
          }
       """

    def writeField(field: FieldDefinition, of: ObjectTypeDefinition): String = {
      if (field.args.nonEmpty) {
        s"${writeDescription(field.description)}${protectedReservedName(field.name)}: ${of.name.capitalize}${
          field.name.capitalize
        }Args => ${writeType(field.ofType)}"
      } else {
        s"""${writeDescription(field.description)}${protectedReservedName(field.name)}: ${writeType(field.ofType)}"""
      }
    }

    def writeInputValue(value: InputValueDefinition, of: InputObjectTypeDefinition): String = {
      s"""${writeDescription(value.description)}${protectedReservedName(value.name)}: ${writeType(value.ofType)}"""
    }

    def writeArguments(field: FieldDefinition): String = {
      def fields(args: List[InputValueDefinition]): String =
        s"${args.map { arg =>
          s"${protectedReservedName(arg.name)}: ${writeType(arg.ofType)}"
        }.mkString(", ")}"

      if (field.args.nonEmpty) {
        s"case class ${field.name.capitalize}Args(${fields(field.args)})"
      } else {
        ""
      }
    }

    def writeDescription(description: Option[String]): String =
      description.fold("")(d => s"""@GQLDescription(\"\"\"$d\"\"\")
                                   |""".stripMargin)

    def writeType(t: Type): String =
      t match {
        case NamedType(name, true)   => name
        case NamedType(name, false)  => s"Option[$name]"
        case ListType(ofType, true)  => s"List[${writeType(ofType)}]"
        case ListType(ofType, false) => s"Option[List[${writeType(ofType)}]]"
      }

  }

  object CodeGen {
    import caliban.parsing._
    import caliban.parsing.adt._
    import java.io.{ File, PrintWriter }
    import zio.console.{ putStrLn, Console => ZConsole }
    import zio.{ RIO, Runtime => ZRuntime, Task => ZTask, UIO }

    def generate(
        schemaPath: String,
        toPath: String,
        writer: (Document, String, Option[String]) => String
    ): RIO[ZConsole, Unit] =
      for {
        _             <- putStrLn(s"Generating code for $schemaPath")
        schema_string <- ZTask(scala.io.Source.fromFile(schemaPath)).bracket(f => UIO(f.close()), f => ZTask(f.mkString))
        schema        <- Parser.parseQuery(schema_string)
        code          = writer(schema, "Client", None)
        _             <- ZTask(new PrintWriter(new File(toPath))).bracket(q => UIO(q.close()), pw => ZTask(pw.println(code)))
        _             <- putStrLn(s"Code generation done")
      } yield ()
  }

  import zio.console.{ putStrLn, Console => ZConsole }
  import zio.{ RIO, Runtime => ZRuntime, Task => ZTask, UIO }

  def generateCode = T {
    val runtime = ZRuntime.unsafeFromLayer(ZConsole.live)
    runtime.unsafeRun(
      CodeGen.generate(schema.toString(), output.toString(), SchemaWriter.write)
        .catchAll(reason => putStrLn(reason.toString) *> putStrLn(reason.getStackTrace.mkString("\n")))
        .as(1)
      )
  }
}

/*
trait CalibanGraphqlGeneratorModule extends ScalaModule {
  override def generatedSources = T { super.generatedSources() :+ compileScalaPB() }

  override def ivyDeps = T {
    super.ivyDeps() ++
      caliban.libs_gen
  }

  def graphqlSources: Sources = T.sources {
    millSourcePath / 'graphql
  }

  def compileScalaPB: T[PathRef] = T.persistent {
    ScalaPBWorkerApi.scalaPBWorker
      .compile(
        scalaPBClasspath().map(_.path),
        scalaPBProtocPath(),
        scalaPBSources().map(_.path),
        scalaPBOptions(),
        T.dest,
        scalaPBIncludePath().map(_.path))
  }
}

*/
