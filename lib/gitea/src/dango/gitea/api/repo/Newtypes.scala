package dango.gitea.api.repo

object Newtypes {
  @io.estatico.newtype.macros.newtype
  final case class Owner(private val v: String)

  @io.estatico.newtype.macros.newtype
  final case class RepoName(private val v: String)
}
