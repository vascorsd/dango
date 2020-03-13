package dango

import zio.App
import zio.console._

object DangoCLI extends App {

  val program =
    for {
      _ <- putStrLn("Dango jumping...")
    } yield (Damn("here sun"))

  def run(args: List[String]) = {
    program.ignore.map(_ => 0)
  }
}
