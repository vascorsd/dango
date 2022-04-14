package dango.cli

case class Repository(owner: Repository.Owner, repo: Repository.Name)

object Repository {
  @io.estatico.newtype.macros.newtype
  final case class Owner(v: String)

  @io.estatico.newtype.macros.newtype
  final case class Name(v: String)
}
