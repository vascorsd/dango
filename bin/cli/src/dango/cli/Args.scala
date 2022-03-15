package dango.cli

import cats.implicits._
import cats.data.Validated
import com.monovore.decline.{Argument, Opts}
import dango.gitea.api.repo._
import io.estatico.newtype.ops._

import java.net.URI

final case class Args(
    platform: Platform,
    hostUrl: Option[URI],
    owner: RepoOwner,
    repo: RepoName
)

object Args {
  def read: Opts[Args] = {
    (platformOpt, hostUrlOpt.orNone, ownerOpt, repoOpt).mapN(Args.apply)
  }

  private val platformOpt = Opts.argument[Platform]()

  private val hostUrlOpt = Opts.option[URI](
    "host-url",
    "Use a different host/url for the platform instead of the default"
  )

  private val ownerOpt = Opts.argument[RepoOwner]("owner")
  private val repoOpt  = Opts.argument[RepoName]("repo")

  implicit def platformArg: Argument[Platform] = Argument.from("platform") { str =>
    Platform.from(str) match {
      case Some(v) => Validated.valid(v)
      case None =>
        Validated.invalidNel(
          s"Invalid Platform. Available: ${Platform.names.mkString(", ")}. Given: ${str}"
        )
    }
  }

  implicit def repoOwnerArg: Argument[RepoOwner] =
    implicitly[Argument[String]].coerce[Argument[RepoOwner]]

  implicit def repoNameArg: Argument[RepoName] =
    Argument[String].coerce[Argument[RepoName]]
}
