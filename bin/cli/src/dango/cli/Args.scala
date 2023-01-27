# SPDX-FileCopyrightText: 2023 Vasco Dias <m+git@vascorsd.com>
#
# SPDX-License-Identifier: AGPL-3.0-or-later

package dango.cli

import cats.syntax.all._
import com.monovore.decline.Command
import com.monovore.decline.Opts
import dango.cli.Operation.Repo

import java.net.URI

final case class Args(
    hostUrl: Option[URI],
    platform: Platform,
    owner: Repository.Owner,
    repo: Repository.Name,
    command: Operation
)

object Args extends ArgsInstances {
  def read: Opts[Args] = {
    (
      hostUrlOpt.orNone,
      platformOpt,
      ownerOpt,
      repoOpt,
      Opts.subcommands[Operation](
        Command("info", "Obtain general information about the repository")(
          Opts.apply(Repo.Info)
        ),
        Command("releases", "Releases information")(Opts.apply(Repo.Releases))
      )
    ).mapN(Args.apply)
  }

  private val platformOpt = Opts.argument[Platform]()

  private val hostUrlOpt = Opts.option[URI](
    "host-url",
    "Use a different host/url for the platform instead of the default"
  )

  private val ownerOpt = Opts.argument[Repository.Owner]("owner")
  private val repoOpt  = Opts.argument[Repository.Name]("repo")

  // Opts.subcommand("test", "fuuuuk")
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
          s"Invalid Platform.\nGiven: ${str}.\nAvailable: ${Platform.names.mkString(", ")}."
        )
    }
  }

  implicit def repoOwnerArg: Argument[Repository.Owner] =
    implicitly[Argument[String]].coerce[Argument[Repository.Owner]]

  implicit def repoNameArg: Argument[Repository.Name] =
    Argument[String].coerce[Argument[Repository.Name]]
}
