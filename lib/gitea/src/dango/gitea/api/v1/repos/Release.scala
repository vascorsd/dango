// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api
package v1
package repos

import dango.internal.derivation._

final case class Release(
    id: Release.Id,
    name: String,
    body: String,
    author: User,
    draft: Boolean,
    prerelease: Boolean,
    tag_name: String,
    url: String,
    zipball_url: String,
    tarball_url: String,
    target_commitish: String,
    html_url: String
) derives CirceEncoderObject,
      CirceDecoder,
      TapirSchema

object Release {

  opaque type Id = Int
  object Id {
    def make(v: Int): Id             = v
    extension (v: Id) def value: Int = v

    given CirceDecoder[Id] =
      summon[CirceDecoder[Int]]

    given CirceEncoder[Id] =
      summon[CirceEncoder[Int]]

    given TapirSchema[Id] =
      summon[TapirSchema[Int]]
        .map(s => Option.apply(make(s)))(_.value)

    given TapirCodecPlain[Id] =
      sttp.tapir.Codec.parsedString(s => make(s.toInt))

  }

  // @io.estatico.newtype.macros.newtype
  // final case class Id(private val v: Int)
  // object Id {
  // implicit val circeEnc: Encoder[Id]   = deriving
  // implicit val circeDec: Decoder[Id]   = deriving
  // implicit val tapirSchema: Schema[Id] = deriving
  // }

  // implicit val tapirSchema: Schema[Release] = tapir.schema.derived
  // implicit val circeEnc: Encoder[Release]   = circe.encoder.deriveMagnoliaEncoder
  // implicit val circeDec: Decoder[Release]   = circe.decoder.deriveMagnoliaDecoder
}
