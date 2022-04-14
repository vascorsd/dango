// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api
package v1
package repos

import dango.internal.derivation._

final case class Permission(
    admin: Boolean,
    push: Boolean,
    pull: Boolean
)

object Permission {
  implicit val tapirSchema: Schema[Permission] = tapir.schema.derived
  implicit val circeEnc: Encoder[Permission]   = circe.encoder.deriveMagnoliaEncoder
  implicit val circeDec: Decoder[Permission]   = circe.decoder.deriveMagnoliaDecoder
}
