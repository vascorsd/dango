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

import dango.gitea.api.repo._
import dango.gitea.client._

object DangoCli
    extends CommandIOApp(
      name = "dango-cli",
      header = "Interact with multiple git providers"
    ) {

  def main: Opts[IO[ExitCode]] = {
    val availableProviders = List("gitea", "github")
    val provider: Opts[String] = Opts
      .argument[String]("provider")
      .validate(
        s"Use one of the providers available: ${availableProviders.mkString(", ")}"
      ) { availableProviders.contains }

    provider.map(Args.apply).map(run)
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

    gitea = GiteaApi.make(uri"https://try.gitea.io", sttpBackend)
    repoInfo <- gitea.repo.info(
      RepoOwner("Mikaela"),
      RepoName("gist-manual")
    )
    releaseInfo <- gitea.repo.releases
      .list(RepoOwner("Mikaela"), RepoName("gist-manual"))

    _ <- IO.println(pprint.pprintln(repoInfo))
    _ <- IO.println(pprint.pprintln(releaseInfo))
  } yield ()

}

case class Args(
    provider: String
)
