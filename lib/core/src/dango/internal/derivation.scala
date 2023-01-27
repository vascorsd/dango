# SPDX-FileCopyrightText: 2023 Vasco Dias <m+git@vascorsd.com>
#
# SPDX-License-Identifier: AGPL-3.0-or-later

package dango.internal

private[dango] object derivation {
  type Schema[T]  = sttp.tapir.Schema[T]
  type Encoder[T] = io.circe.Encoder[T]
  type Decoder[T] = io.circe.Decoder[T]

  object tapir {
    def schema = sttp.tapir.Schema // .derived[T]
  }

  object circe {
    def encoder =
      io.circe.magnolia.derivation.encoder.semiauto // .deriveMagnoliaEncoder[T]
    def decoder =
      io.circe.magnolia.derivation.decoder.semiauto // .deriveMagnoliaDecoder[T]
  }
}
