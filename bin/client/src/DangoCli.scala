package dango
package cli

import cats.effect._

object DangoCli extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO.println(s"hi mom")
      r = clientX
      _ <- IO.println(r)
    } yield ExitCode.Success

  }

  def clientX = {
    import sttp.tapir.client.sttp._
    import sttp.client3._

    val req =
      SttpClientInterpreter()
        .toQuickClient(
          dango.gitea.api.repo.getRepo,
          Some(uri"https://try.gitea.io")
        )
        .apply(("Mikaela", "gist-manual"))

    req
  }
}
