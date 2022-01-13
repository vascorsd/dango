package dango
package cli

import cats.effect._
import dango.gitea.api._
import dango.gitea.client._
import sttp.capabilities.WebSockets
import sttp.capabilities.fs2.Fs2Streams
import sttp.client3._
import sttp.client3.httpclient.fs2.HttpClientFs2Backend

object DangoCli extends IOApp {

  def resources: Resource[IO, SttpBackend[IO, Fs2Streams[IO] with WebSockets]] = {
    HttpClientFs2Backend.resource[IO]()
  }

  def program(
      sttpBackend: SttpBackend[IO, Any]
  ): IO[Unit] = for {
    _ <- IO.println(s"--- gitea client ---")

    gitea = GiteaApi.make(uri"https://try.gitea.io", sttpBackend)
    repoInfo    <- gitea.repos.info(Owner("Mikaela"), RepoName("gist-manual"))
    releaseInfo <- gitea.repos.releases.list(Owner("Mikaela"), RepoName("gist-manual"))

    _ <- IO.println(pprint.pprintln(repoInfo))
    _ <- IO.println(pprint.pprintln(releaseInfo))
  } yield ()

  def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- resources.use { program }
    } yield ExitCode.Success

}
