// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api.repo

final case class SearchResults(
    ok: Boolean,
    data: List[Repository]
)

object SearchResults {
  implicit val tapirSchema: Schema[SearchResults] = schema.derived
  implicit val circeEnc: Encoder[SearchResults]   = circeEncoder.deriveMagnoliaEncoder
  implicit val circeDec: Decoder[SearchResults]   = circeDecoder.deriveMagnoliaDecoder
}
