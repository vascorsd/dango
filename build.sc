import mill._, scalalib._
import $ivy.`com.lihaoyi::mill-contrib-bsp:0.6.1`

trait DangoModule extends ScalaModule {
  def scalaVersion = {
    "2.13.1"
  }

  def scalacPluginIvyDeps = Agg(
    ivy"org.scalameta:::semanticdb-scalac:4.3.0",
    ivy"io.tryp:::splain:0.5.1",
  )

  def scalacOptions = {
    Seq(
      "-encoding",
      "UTF-8",
      "-unchecked",
      "-deprecation",
      "-feature",

      "-Wunused",

      "-Ywarn-numeric-widen",
      "-Yrangepos",
      "-Ywarn-unused:imports",
      "-Ywarn-value-discard",
      "-Ywarn-dead-code",

      "-Xlint:adapted-args",
      "-Xlint:infer-any",
      "-Xlint:missing-interpolator",
      "-Xlint:private-shadow",
      "-Xlint:type-parameter-shadow"
    )
  }
}

object Dependencies {

  object zio {
    val version = "1.0.0-RC18-2"
    val catsInteropVersion = "2.0.0.0-RC12"

    def libs = {
      Agg(
        ivy"dev.zio::zio:$version",
        ivy"dev.zio::zio-streams:$version",
        ivy"dev.zio::zio-interop-cats:$catsInteropVersion"
      )
    }
  }

  object sttp {
    val version = "2.0.0"

    def libs = {
      Agg(
        ivy"com.softwaremill.sttp.client::core:$version"
      )
    }
  }

}

import Dependencies._

object core extends DangoModule {
  def ivyDeps = {
    zio.libs ++
      sttp.libs
  }
}

object app extends DangoModule {
  def moduleDeps = {
    Seq(core)
  }
}
