// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: CC0-1.0

// scalafix rules / dependencies

//ThisBuild / scalafixScalaBinaryVersion := (ThisBuild / scalaBinaryVersion).value
ThisBuild / scalafixDependencies ++= Seq(
  "com.github.liancheng" %% "organize-imports" % "0.6.0",
  "com.github.vovapolu"  %% "scaluzzi"         % "0.1.20"
)
ThisBuild / semanticdbEnabled := true
//ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
