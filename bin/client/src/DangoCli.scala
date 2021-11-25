package dango

import cats.effect._

object DangoCli extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    IO.println(s"hi mom")
      .as(ExitCode.Success)
  }
}
