// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: CC0-1.0

lazy val dango = project
  .in(file("."))
  .aggregate(
    `bin-cli`,
    `lib-core`,
    `lib-gitlab`,
    `lib-github`,
    `lib-gitea`,
    `lib-gogs`,
    `lib-sourcehut`
  )
  .settings(
    publish / skip := true
  )

lazy val `bin-cli` = project
  .in(file("bin/cli"))
  .settings(
    commonSettings
  )
  .dependsOn(`lib-core`, `lib-gitea`)

lazy val `lib-core` = project
  .in(file("lib/core"))
  .settings(
    commonSettings
  )

lazy val `lib-gitlab` = project
  .in(file("lib/gitlab"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val `lib-github` = project
  .in(file("lib/github"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val `lib-gitea` = project
  .in(file("lib/gitea"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val `lib-gogs` = project
  .in(file("lib/gogs"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val `lib-sourcehut` = project
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
    "-Xlint:-byname-implicit",
    // enable language features.
    // implicit conversions required for using newtype macro.
    "-language:implicitConversions"
  ),
  // some simple / saner scala project layout
  Compile / scalaSource       := baseDirectory.value / "src",
  Test / scalaSource          := baseDirectory.value / "test",
  Compile / resourceDirectory := baseDirectory.value / "resources",
  Test / resourceDirectory    := baseDirectory.value / "resources-test",
  // common libraries
  libraryDependencies ++= Seq(
    // basic cats & fs2
    "org.typelevel" %% "cats-core"   % "2.7.0",
    "org.typelevel" %% "cats-effect" % "3.3.3",
    "co.fs2"        %% "fs2-core"    % "3.2.4",
    "co.fs2"        %% "fs2-io"      % "3.2.4",
    // test libs
    "org.scalameta" %% "munit"               % "0.7.29" % Test,
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7"  % Test,
    // config
    "is.cir" %% "ciris" % "2.3.1",
    // sttp / tapir / sttp-client
    "com.softwaremill.sttp.client"  %% "core"                   % "2.2.10",
    "com.softwaremill.sttp.client3" %% "httpclient-backend-fs2" % "3.3.18",
    "com.softwaremill.sttp.tapir"   %% "tapir-core"             % "0.20.0-M4",
    "com.softwaremill.sttp.tapir"   %% "tapir-sttp-client"      % "0.20.0-M4",
    "com.softwaremill.sttp.tapir"   %% "tapir-json-circe"       % "0.20.0-M4",
    "com.softwaremill.sttp.tapir"   %% "tapir-derevo"           % "0.20.0-M4",
    // circe stuff - json serialization
    "io.circe" %% "circe-magnolia-derivation" % "0.7.0",
    // newtype - generate new types with a macro @newtype
    // "io.monix" %% "newtypes-core" % "0.0.1",
    "io.estatico" %% "newtype" % "0.4.4",
    // printing good looking case classes
    "com.lihaoyi" %% "pprint" % "0.7.1"
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
