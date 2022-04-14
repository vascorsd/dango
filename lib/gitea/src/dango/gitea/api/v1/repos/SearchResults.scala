// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api
package v1
package repos

import dango.internal.derivation._

final case class SearchResults(
    ok: Boolean,
    data: List[Repository]
)

object SearchResults {
  implicit val tapirSchema: Schema[SearchResults] = tapir.schema.derived
  implicit val circeEnc: Encoder[SearchResults]   = circe.encoder.deriveMagnoliaEncoder
  implicit val circeDec: Decoder[SearchResults]   = circe.decoder.deriveMagnoliaDecoder
}
