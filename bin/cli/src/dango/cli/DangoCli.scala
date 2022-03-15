// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango
package cli

import cats.effect._
import com.monovore.decline._
import com.monovore.decline.effect.CommandIOApp
import sttp.capabilities.WebSockets
import sttp.capabilities.fs2.Fs2Streams
import sttp.client3._
import sttp.client3.httpclient.fs2.HttpClientFs2Backend
import dango.gitea.client._
import sttp.model.Uri

object DangoCli
    extends CommandIOApp(
      name = "dango-cli",
      header = "Interact with multiple git hosting platforms"
    ) {

  def main: Opts[IO[ExitCode]] = {
    Args.read.map(run)
  }

  def run(args: Args): IO[ExitCode] =
    for {
      _ <- resources.use(program(args, _))
    } yield ExitCode.Success

  def resources: Resource[IO, SttpBackend[IO, Fs2Streams[IO] with WebSockets]] = {
    HttpClientFs2Backend.resource[IO]()
  }

  def program(
      args: Args,
      sttpBackend: SttpBackend[IO, Any]
  ): IO[Unit] = for {
    _ <- IO.println(s"--- gitea client ---")

    gitea = (args.platform, args.hostUrl) match {
      case (Platform.Gitea, Some(url)) =>
        GiteaApi.make(Uri(url), sttpBackend)

      case (Platform.Gitea, None) =>
        GiteaApi.make(uri"https://try.gitea.io", sttpBackend)

      case _ => ???
    }

    repoInfo <- gitea.repo.info(
      args.owner,
      args.repo
    )

    // releaseInfo <- gitea.repo.releases
    //  .list(RepoOwner("Mikaela"), RepoName("gist-manual"))

    _ <- IO.println(pprint.pprintln(repoInfo))
    // _ <- IO.println(pprint.pprintln(releaseInfo))
  } yield ()

}
