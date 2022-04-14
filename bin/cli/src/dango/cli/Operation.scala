package dango.cli

sealed trait Operation[+A]
object Operation {
  case object Repo {
    case class Info(repo: Repository)     extends Operation[Unit]
    case class Releases(repo: Repository) extends Operation[Unit]
  }
}

sealed trait Result[+A]
object Result {
  case object Un
  case object None extends Result[Unit]
}
