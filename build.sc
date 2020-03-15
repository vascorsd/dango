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
    def moduleDeps = {
      Seq(gitlab, github)
    }

    def ivyDeps = {
      Dependencies.zio.libs ++
        Dependencies.caliban.libs ++
        Dependencies.sttp.libs
    }
  }

  object gitlab extends DangoModule with CalibanCodegenModule {
    val fileName = "GitlabApi"

    def ivyDeps = {
      Dependencies.zio.libs ++
        Dependencies.caliban.libs
    }
  }

  object github extends DangoModule with CalibanCodegenModule {
    val fileName = "GithubApi"

    def ivyDeps = {
      Dependencies.zio.libs ++
        Dependencies.caliban.libs
    }
  }
}

trait CalibanCodegenModule extends ScalaModule {
  def packageName = "dango.generated"
  def fileName = "ClientGenerated"

  def schema = {
    millSourcePath / "resources" / "schema.graphql"
  }

  def outputClient = {
    millSourcePath / "src" / s"${fileName}.scala"
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
        code          = writer(schema, fileName, Some(packageName))
        _             <- ZTask(new PrintWriter(new File(toPath))).bracket(q => UIO(q.close()), pw => ZTask(pw.println(code)))
        _             <- putStrLn(s"Code generation done")
      } yield ()
  }

  object ClientWriter {
    import scala.annotation.tailrec
    import caliban.Value.StringValue
    import caliban.parsing.adt.Definition.TypeSystemDefinition.TypeDefinition
    import caliban.parsing.adt.Definition.TypeSystemDefinition.TypeDefinition._
    import caliban.parsing.adt.Type.{ ListType, NamedType }
    import caliban.parsing.adt.{ Document, Type }

    def write(schema: Document, objectName: String = "Client", packageName: Option[String] = None): String = {
      val schemaDef = Document.schemaDefinitions(schema).headOption

      val typesMap: Map[String, TypeDefinition] = schema.definitions.collect {
        case op @ ObjectTypeDefinition(_, name, _, _, _)   => name -> op
        case op @ InputObjectTypeDefinition(_, name, _, _) => name -> op
        case op @ EnumTypeDefinition(_, name, _, _)        => name -> op
        case op @ UnionTypeDefinition(_, name, _, _)       => name -> op
        case op @ ScalarTypeDefinition(_, name, _)         => name -> op
        case op @ InterfaceTypeDefinition(_, name, _, _)   => name -> op
      }.toMap

      val objects = Document
        .objectTypeDefinitions(schema)
        .filterNot(obj =>
                     reservedType(obj) ||
                       schemaDef.exists(_.query.getOrElse("Query") == obj.name) ||
                       schemaDef.exists(_.mutation.getOrElse("Mutation") == obj.name) ||
                       schemaDef.exists(_.subscription.getOrElse("Subscription") == obj.name)
                   )
        .map(writeObject(_, typesMap))
        .mkString("\n")

      val inputs = Document.inputObjectTypeDefinitions(schema).map(writeInputObject).mkString("\n")

      val enums = Document.enumTypeDefinitions(schema).map(writeEnum).mkString("\n")

      val scalars = Document
        .scalarTypeDefinitions(schema)
        .filterNot(s => supportedScalars.contains(s.name))
        .map(writeScalar)
        .mkString("\n")

      val queries = Document
        .objectTypeDefinition(schema, schemaDef.flatMap(_.query).getOrElse("Query"))
        .map(t => writeRootQuery(t, typesMap))
        .getOrElse("")

      val mutations = Document
        .objectTypeDefinition(schema, schemaDef.flatMap(_.mutation).getOrElse("Mutation"))
        .map(t => writeRootMutation(t, typesMap))
        .getOrElse("")

      val imports = s"""${if (enums.nonEmpty)
        """import caliban.client.CalibanClientError.DecodingError
          |""".stripMargin
      else ""}${if (objects.nonEmpty || queries.nonEmpty || mutations.nonEmpty)
        """import caliban.client.FieldBuilder._
          |import caliban.client.SelectionBuilder._
          |""".stripMargin
      else
        ""}${if (enums.nonEmpty || objects.nonEmpty || queries.nonEmpty || mutations.nonEmpty || inputs.nonEmpty)
        """import caliban.client._
          |""".stripMargin
      else ""}${if (queries.nonEmpty || mutations.nonEmpty)
        """import caliban.client.Operations._
          |""".stripMargin
      else ""}${if (enums.nonEmpty || inputs.nonEmpty)
        """import caliban.client.Value._
          |""".stripMargin
      else ""}"""

      s"""${packageName.fold("")(p => s"package $p\n\n")}$imports
         |
         |object $objectName {
         |
         |  $scalars
         |  $enums
         |  $objects
         |  $inputs
         |  $queries
         |  $mutations
         |
         |}""".stripMargin
    }

    def reservedType(typeDefinition: ObjectTypeDefinition): Boolean =
      typeDefinition.name == "Query" || typeDefinition.name == "Mutation" || typeDefinition.name == "Subscription"

    def writeRootQuery(typedef: ObjectTypeDefinition, typesMap: Map[String, TypeDefinition]): String =
      s"""type ${typedef.name} = RootQuery
         |object ${typedef.name} {
         |  ${typedef.fields.map(writeField(_, "RootQuery", typesMap)).mkString("\n  ")}
         |}
         |""".stripMargin

    def writeRootMutation(typedef: ObjectTypeDefinition, typesMap: Map[String, TypeDefinition]): String =
      s"""type ${typedef.name} = RootMutation
         |object ${typedef.name} {
         |  ${typedef.fields.map(writeField(_, "RootMutation", typesMap)).mkString("\n  ")}
         |}
         |""".stripMargin

    def writeObject(typedef: ObjectTypeDefinition, typesMap: Map[String, TypeDefinition]): String =
      s"""type ${typedef.name}
         |object ${typedef.name} {
         |  ${typedef.fields.map(writeField(_, typedef.name, typesMap)).mkString("\n  ")}
         |}
         |""".stripMargin

    def writeInputObject(typedef: InputObjectTypeDefinition): String =
      s"""case class ${typedef.name}(${writeArgumentFields(typedef.fields)})
         |object ${typedef.name} {
         |  implicit val encoder: ArgEncoder[${typedef.name}] = new ArgEncoder[${typedef.name}] {
         |    override def encode(value: ${typedef.name}): Value =
         |      ObjectValue(List(${typedef.fields
        .map(f => s""""${f.name}" -> ${writeInputValue(f.ofType, s"value.${safeName(f.name)}", typedef.name)}""")
        .mkString(", ")}))
         |    override def typeName: String = "${typedef.name}"
         |  }
         |}""".stripMargin

    def writeInputValue(t: Type, fieldName: String, typeName: String): String =
      t match {
        case NamedType(name, true) =>
          if (name == typeName) s"encode($fieldName)"
          else s"implicitly[ArgEncoder[${mapTypeName(name)}]].encode($fieldName)"
        case NamedType(name, false) =>
          s"$fieldName.fold(NullValue: Value)(value => ${writeInputValue(NamedType(name, nonNull = true), "value", typeName)})"
        case ListType(ofType, true) =>
          s"ListValue($fieldName.map(value => ${writeInputValue(ofType, "value", typeName)}))"
        case ListType(ofType, false) =>
          s"$fieldName.fold(NullValue: Value)(value => ${writeInputValue(ListType(ofType, nonNull = true), "value", typeName)})"
      }

    def writeEnum(typedef: EnumTypeDefinition): String =
      s"""sealed trait ${typedef.name} extends scala.Product with scala.Serializable
        object ${typedef.name} {
          ${typedef.enumValuesDefinition
        .map(v => s"case object ${safeName(v.enumValue)} extends ${typedef.name}")
        .mkString("\n")}

          implicit val decoder: ScalarDecoder[${typedef.name}] = {
            ${typedef.enumValuesDefinition
        .map(v => s"""case StringValue ("${v.enumValue}") => Right(${typedef.name}.${safeName(v.enumValue)})""")
        .mkString("\n")}
            case other => Left(DecodingError(s"Can't build ${typedef.name} from input $$other"))
          }
          implicit val encoder: ArgEncoder[${typedef.name}] = new ArgEncoder[${typedef.name}] {
            override def encode(value: ${typedef.name}): Value = value match {
              ${typedef.enumValuesDefinition
        .map(v => s"""case ${typedef.name}.${safeName(v.enumValue)} => EnumValue("${v.enumValue}")""")
        .mkString("\n")}
            }
            override def typeName: String = "${typedef.name}"
          }
        }
       """

    def writeScalar(typedef: ScalarTypeDefinition): String =
      s"""type ${typedef.name} = String
        """

    def safeName(name: String): String =
      if (reservedKeywords.contains(name)) s"`$name`" else name

    @tailrec
    def getTypeLetter(typesMap: Map[String, TypeDefinition], letter: String = "A"): String =
      if (!typesMap.contains(letter)) letter else getTypeLetter(typesMap, letter + "A")

    def writeField(field: FieldDefinition, typeName: String, typesMap: Map[String, TypeDefinition]): String = {
      val name = safeName(field.name)
      val description = field.description match {
        case None    => ""
        case Some(d) => s"/**\n * $d\n */\n"
      }
      val deprecated = field.directives.find(_.name == "deprecated") match {
        case None => ""
        case Some(directive) =>
          s"@deprecated(${directive.arguments.collectFirst {
            case ("reason", StringValue(reason)) => reason
          }.fold(""""",""""")(r => s""""$r",""""")})\n"
      }
      val fieldType = getTypeName(field.ofType)
      val isScalar = typesMap
        .get(fieldType)
        .collect {
          case _: ScalarTypeDefinition => true
          case _: EnumTypeDefinition   => true
          case _                       => false
        }
        .getOrElse(true)
      val unionTypes = typesMap
        .get(fieldType)
        .collect {
          case UnionTypeDefinition(_, _, _, memberTypes) => memberTypes.flatMap(typesMap.get)
        }
        .getOrElse(Nil)
        .collect {
          case o: ObjectTypeDefinition => o
        }
      val interfaceTypes = typesMap
        .get(fieldType)
        .collect {
          case InterfaceTypeDefinition(_, name, _, _) => name
        }
        .map(interface =>
               typesMap.values.collect {
                 case o @ ObjectTypeDefinition(_, _, implements, _, _) if implements.exists(_.name == interface) => o
               }
             )
        .getOrElse(Nil)
      val typeLetter = getTypeLetter(typesMap)
      val (typeParam, innerSelection, outputType, builder) =
        if (isScalar) {
          (
            "",
            "",
            writeType(field.ofType),
            writeTypeBuilder(field.ofType, "Scalar()")
          )
        } else if (unionTypes.nonEmpty) {
          (
            s"[$typeLetter]",
            s"(${unionTypes.map(t => s"""on${t.name}: SelectionBuilder[${t.name}, $typeLetter]""").mkString(", ")})",
            writeType(field.ofType).replace(fieldType, typeLetter),
            writeTypeBuilder(
              field.ofType,
              s"ChoiceOf(Map(${unionTypes.map(t => s""""${t.name}" -> Obj(on${t.name})""").mkString(", ")}))"
              )
          )
        } else if (interfaceTypes.nonEmpty) {
          (
            s"[$typeLetter]",
            s"(${interfaceTypes.map(t => s"""on${t.name}: Option[SelectionBuilder[${t.name}, $typeLetter]] = None""").mkString(", ")})",
            writeType(field.ofType).replace(fieldType, typeLetter),
            writeTypeBuilder(
              field.ofType,
              s"ChoiceOf(Map(${interfaceTypes.map(t => s""""${t.name}" -> on${t.name}""").mkString(", ")}).collect { case (k, Some(v)) => k -> Obj(v)})"
              )
          )
        } else {
          (
            s"[$typeLetter]",
            s"(innerSelection: SelectionBuilder[$fieldType, $typeLetter])",
            writeType(field.ofType).replace(fieldType, typeLetter),
            writeTypeBuilder(field.ofType, "Obj(innerSelection)")
          )
        }
      val args = field.args match {
        case Nil  => ""
        case list => s"(${writeArgumentFields(list)})"
      }
      val argBuilder = field.args match {
        case Nil => ""
        case list =>
          s", arguments = List(${list.map(arg => s"""Argument("${arg.name}", ${safeName(arg.name)})""").mkString(", ")})"
      }

      s"""$description${deprecated}def $name$typeParam$args$innerSelection: SelectionBuilder[$typeName, $outputType] = Field("${field.name}", $builder$argBuilder)"""
    }

    def writeArgumentFields(args: List[InputValueDefinition]): String =
      s"${args.map(arg => s"${safeName(arg.name)}: ${writeType(arg.ofType)}${writeDefaultArgument(arg)}").mkString(", ")}"

    def writeDefaultArgument(arg: InputValueDefinition): String =
      arg.ofType match {
        case t if t.nullable => " = None"
        case ListType(_, _)  => " = Nil"
        case _               => ""
      }

    def writeArguments(field: FieldDefinition): String =
      if (field.args.nonEmpty) {
        s"case class ${field.name.capitalize}Args(${writeArgumentFields(field.args)})"
      } else ""

    def writeDescription(description: Option[String]): String =
      description.fold("")(d => s"""@GQLDescription("$d")
                                   |""".stripMargin)

    def mapTypeName(s: String): String = s match {
      case "Float" => "Double"
      case "ID"    => "String"
      case other   => other
    }

    def writeType(t: Type): String =
      t match {
        case NamedType(name, true)   => mapTypeName(name)
        case NamedType(name, false)  => s"Option[${mapTypeName(name)}]"
        case ListType(ofType, true)  => s"List[${writeType(ofType)}]"
        case ListType(ofType, false) => s"Option[List[${writeType(ofType)}]]"
      }

    def writeTypeBuilder(t: Type, inner: String): String =
      t match {
        case NamedType(_, true)  => inner
        case NamedType(_, false) => s"OptionOf($inner)"
        case ListType(of, true)  => s"ListOf(${writeTypeBuilder(of, inner)})"
        case ListType(of, false) => s"OptionOf(ListOf(${writeTypeBuilder(of, inner)}))"
      }

    @tailrec
    def getTypeName(t: Type): String = t match {
      case NamedType(name, _)  => name
      case ListType(ofType, _) => getTypeName(ofType)
    }

    val supportedScalars =
      Set("Int", "Float", "Double", "Long", "Unit", "String", "Boolean", "BigInt", "BigDecimal", "ID")

    val reservedKeywords = Set(
      "abstract",
      "case",
      "catch",
      "class",
      "def",
      "do",
      "else",
      "extends",
      "false",
      "final",
      "finally",
      "for",
      "forSome",
      "if",
      "implicit",
      "import",
      "lazy",
      "match",
      "new",
      "null",
      "object",
      "override",
      "package",
      "private",
      "protected",
      "return",
      "sealed",
      "super",
      "this",
      "throw",
      "trait",
      "try",
      "true",
      "type",
      "val",
      "var",
      "while",
      "with",
      "yield"
      )
  }

  import zio.console.{ putStrLn, Console => ZConsole }
  import zio.{ RIO, Runtime => ZRuntime, Task => ZTask, UIO }

  def generateCode = T {
    ZRuntime
      .unsafeFromLayer(ZConsole.live)
      .unsafeRun(
        CodeGen.generate(schema.toString(), outputClient.toString(), ClientWriter.write)
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
