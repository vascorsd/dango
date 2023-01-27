# SPDX-FileCopyrightText: 2023 Vasco Dias <m+git@vascorsd.com>
#
# SPDX-License-Identifier: AGPL-3.0-or-later

// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango
package cli

import cats.effect._
import com.monovore.decline._
import com.monovore.decline.effect.CommandIOApp
import dango.cli.Operation.Repo
import dango.gitea.client._
import sttp.client3._
import sttp.model.Uri

object Main
    extends CommandIOApp(
      name = "dango-cli",
      header = "Interact with multiple git hosting platforms"
    ) {

  def main: Opts[IO[ExitCode]] = {
    Args.read.map { args =>
      for {
        // some config reading

        // resources initialization
        _ <- Resources
          .make[IO]()
          .use { res => program(args, res) }
      } yield ExitCode.Success
    }
  }

  def program(
      args: Args,
      resources: Resources[IO]
  ): IO[Unit] = for {
    _ <- IO.println(())

    _ <- args.platform match {
      case Platform.Gitea =>
        val host = args.hostUrl.fold[Uri](uri"https://try.gitea.io")(Uri(_))

        val gitea =
          GiteaApi.make[IO, Any](resources.sttpBackend1, host)

        args.command match {
          case Repo.Info =>
            val repoInfo = gitea.repos.info(
              dango.gitea.api.v1.repos.RepoOwner(args.owner.v),
              dango.gitea.api.v1.repos.RepoName(args.repo.v)
            )

            repoInfo.flatMap(r => IO.println(pprint.pprintln(r)))

          case Repo.Releases =>
            val releaseInfo = gitea.repos.releases.list(
              dango.gitea.api.v1.repos.RepoOwner(args.owner.v),
              dango.gitea.api.v1.repos.RepoName(args.repo.v)
            )

            releaseInfo.flatMap(r => IO.println(pprint.pprintln(r)))
        }

      case _ =>
        IO.println("NOPE")
    }

  } yield ()

  /*def doActionOn[A, B](
      platform: (Platform, Option[URI])
  ): B = { op: Operation[A] =>
    platform match {
      case (Platform.Github, _)        => ???
      case (Platform.Gitlab, _)        => ???
      case (Platform.Gitea, Some(url)) => GiteaApi.make(_, Uri(url))
      case (Platform.Gitea, None)      => GiteaApi.make(_, uri"https://try.gitea.io")
      case (Platform.Gogs, _)          => ???
      case (Platform.Sourcehut, _)     => ???
    }
  }*/
}
