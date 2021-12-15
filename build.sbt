lazy val dango = project
  .in(file("."))
  .aggregate(
    bin,
    core,
    gitlab,
    github,
    gitea,
    gogs,
    sourcehut
  )
  .settings(
    publish / skip := true
  )

lazy val bin = project
  .in(file("bin/client"))
  .settings(
    commonSettings
  )
  .dependsOn(core, gitea)

lazy val core = project
  .in(file("lib/core"))
  .settings(
    commonSettings
  )

lazy val gitlab = project
  .in(file("lib/gitlab"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val github = project
  .in(file("lib/github"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val gitea = project
  .in(file("lib/gitea"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val gogs = project
  .in(file("lib/gogs"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val sourcehut = project
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
    // magic ? not really sure what it does or when is need. more scala yonkers.
    // ok, seems that if I have any code that USES macro expansions, then this needs
    // to be on. https://docs.scala-lang.org/overviews/macros/annotations.html
    // "-Ymacro-annotations",
    // warns
    "-Werror",
    "-Wnumeric-widen",
    "-Wvalue-discard",
    "-Wdead-code",
    "-Wextra-implicit",
    // lints
    "-Xlint",
    // yet another not surpring scala bug yet again...
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
    "co.fs2"        %% "fs2-core"    % "3.2.2",
    "co.fs2"        %% "fs2-io"      % "3.2.2",
    // test libs:
    "org.scalameta" %% "munit"               % "0.7.29" % Test,
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.6"  % Test,
    // --
    "is.cir" %% "ciris" % "2.2.1",
    // sttp / tapir
    "com.softwaremill.sttp.client" %% "core"              % "2.0.5",
    "com.softwaremill.sttp.tapir"  %% "tapir-core"        % "0.19.1",
    "com.softwaremill.sttp.tapir"  %% "tapir-sttp-client" % "0.19.1",
    "com.softwaremill.sttp.tapir"  %% "tapir-json-circe"  % "0.19.1"
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
