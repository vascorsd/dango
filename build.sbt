lazy val dango = project
  .in(file("."))
  .aggregate(
    bin_cli,
    lib_core,
    lib_gitlab,
    lib_github,
    lib_gitea,
    lib_gogs,
    lib_sourcehut
  )
  .settings(
    publish / skip := true
  )

lazy val bin_cli = project
  .in(file("bin/cli"))
  .settings(
    commonSettings
  )
  .dependsOn(lib_core, lib_gitea)

lazy val lib_core = project
  .in(file("lib/core"))
  .settings(
    commonSettings
  )

lazy val lib_gitlab = project
  .in(file("lib/gitlab"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val lib_github = project
  .in(file("lib/github"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val lib_gitea = project
  .in(file("lib/gitea"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val lib_gogs = project
  .in(file("lib/gogs"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val lib_sourcehut = project
  .in(file("lib/sourcehut"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val commonSettings = Seq(
  // basic sanity
  fork           := true,
  connectInput   := true,
  outputStrategy := Some(StdoutOutput),
  // test settings
  Test / parallelExecution := true,
  testFrameworks += new TestFramework("munit.Framework"),
  // --
  scalacOptions ++= Seq(
    // most basic needed flags
    "-encoding",
    "UTF-8",
    "-unchecked",
    "-deprecation",
    "-feature",
    "-explaintypes",
    // Needs to be on for macros to work. https://docs.scala-lang.org/overviews/macros/annotations.html
    // It means that removing makes the @newtype and @derive stop working.
    "-Ymacro-annotations",
    // warns
    "-Werror",
    "-Wnumeric-widen",
    "-Wvalue-discard",
    "-Wdead-code",
    "-Wextra-implicit",
    // lints
    "-Xlint",
    // yet another not surprising scala bug yet again...
    // without this circe semiauto functions trigger
    // "Block result was adapted via implicit conversion (method apply) taking a by-name parameter",
    // https://users.scala-lang.org/t/2-13-3-by-name-implicit-linting-error/6334
    "-Xlint:-byname-implicit"
  ),
  // some simple / saner scala project layout
  Compile / scalaSource       := baseDirectory.value / "src",
  Test / scalaSource          := baseDirectory.value / "test",
  Compile / resourceDirectory := baseDirectory.value / "resources",
  Test / resourceDirectory    := baseDirectory.value / "resources-test",
  // common libraries
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-core"   % "2.7.0",
    "org.typelevel" %% "cats-effect" % "3.3.0",
    "co.fs2"        %% "fs2-core"    % "3.2.4",
    "co.fs2"        %% "fs2-io"      % "3.2.4",
    // test libs:
    "org.scalameta" %% "munit"               % "0.7.29" % Test,
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7"  % Test,
    // --
    "is.cir" %% "ciris" % "2.3.1",
    // sttp / tapir / sttp-client
    "com.softwaremill.sttp.client"  %% "core"                   % "2.2.10",
    "com.softwaremill.sttp.client3" %% "httpclient-backend-fs2" % "3.3.17",
    "com.softwaremill.sttp.tapir"   %% "tapir-core"             % "0.19.3",
    "com.softwaremill.sttp.tapir"   %% "tapir-sttp-client"      % "0.19.3",
    "com.softwaremill.sttp.tapir"   %% "tapir-json-circe"       % "0.19.3",
    "com.softwaremill.sttp.tapir"   %% "tapir-derevo"           % "0.19.3",
    // derevo - to generate typeclass instances with a macro @derive
    "tf.tofu" %% "derevo-cats"           % "0.12.8",
    "tf.tofu" %% "derevo-circe"          % "0.12.8",
    "tf.tofu" %% "derevo-circe-magnolia" % "0.12.8",
    // newtype - generate new types with a macro @newtype
    // "io.monix" %% "newtypes-core" % "0.0.1",
    "io.estatico" %% "newtype" % "0.4.4"
  ),
  // compiler plugins
  addCompilerPlugin(
    "org.typelevel" %% "kind-projector" % "0.13.2" cross CrossVersion.full
  ),
  addCompilerPlugin(
    "com.olegpy" %% "better-monadic-for" % "0.3.1"
  ),
  addCompilerPlugin(
    scalafixSemanticdb
  )
)
