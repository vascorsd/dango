package dango.cli

import com.monovore.decline.Opts
import cats.syntax.all._

import java.net.URI

final case class Args(
    hostUrl: Option[URI],
    platform: Platform,
    owner: Repository.Owner,
    repo: Repository.Name
)

object Args extends ArgsInstances {
  def read: Opts[Args] = {
    (
      hostUrlOpt.orNone,
      platformOpt,
      ownerOpt,
      repoOpt
    ).mapN(Args.apply)
  }

  private val platformOpt = Opts.argument[Platform]()

  private val hostUrlOpt = Opts.option[URI](
    "host-url",
    "Use a different host/url for the platform instead of the default"
  )

  private val ownerOpt = Opts.argument[Repository.Owner]("owner")
  private val repoOpt  = Opts.argument[Repository.Name]("repo")
}

trait ArgsInstances {
  import com.monovore.decline.Argument
  import cats.data._
  import io.estatico.newtype.ops._

  implicit def platformArg: Argument[Platform] = Argument.from("platform") { str =>
    Platform.from(str) match {
      case Some(v) => Validated.valid(v)
      case None =>
        Validated.invalidNel(
          s"Invalid Platform. Available: ${Platform.names.mkString(", ")}. Given: ${str}"
        )
    }
  }

  implicit def repoOwnerArg: Argument[Repository.Owner] =
    implicitly[Argument[String]].coerce[Argument[Repository.Owner]]

  implicit def repoNameArg: Argument[Repository.Name] =
    Argument[String].coerce[Argument[Repository.Name]]
}
