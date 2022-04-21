package dango.cli

sealed trait Operation extends Product with Serializable
object Operation {
  case object Repo {
    case object Info     extends Operation
    case object Releases extends Operation
  }
}
