package dango.gitea

import io.estatico.newtype.macros.newtype

import scala.language.implicitConversions

package object api {
  @newtype
  final case class Owner(value: String)

  @newtype
  final case class RepoName(value: String)
}
