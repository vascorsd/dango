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
        ivy"com.github.ghostdogpr::caliban-client:$version",
      )
    }
  }
}

import Dependencies._

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

object lib extends Module {
  object core extends DangoModule {
    def ivyDeps = {
      zio.libs ++
        caliban.libs ++
        sttp.libs
    }
  }
}


