// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api.repo

final case class User(
    id: Int,
    login: String,
    full_name: String,
    email: String,
    avatar_url: String
)

object User {
  @io.estatico.newtype.macros.newtype
  final case class UserId(private val v: Int)
  object UserId {
    implicit val tapirSchema: Schema[UserId] = deriving
    implicit val circeEnc: Encoder[UserId]   = deriving
    implicit val circeDec: Decoder[UserId]   = deriving
  }

  implicit val tapirSchema: Schema[User] = schema.derived
  implicit val circeEnc: Encoder[User]   = circeEncoder.deriveMagnoliaEncoder
  implicit val circeDec: Decoder[User]   = circeDecoder.deriveMagnoliaDecoder
}
