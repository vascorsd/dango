package dango

import zio.{App, ZIO}
import zio.console._

object DangoCLI extends App {

  val program: ZIO[Console, Nothing, Unit] =
    for {
      _ <- putStrLn("Dango jumping...")
    } yield ()

  def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] = {
    program.ignore
      .map(_ => 0)
  }
}

object x {
  case class Dad(mom: y.Mom)
}

object y {
  case class Mom(dad: x.Dad)
}
