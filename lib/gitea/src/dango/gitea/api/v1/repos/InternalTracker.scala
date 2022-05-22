// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api
package v1
package repos

import dango.internal.derivation._

final case class InternalTracker(
    enable_time_tracker: Boolean,
    allow_only_contributors_to_track_time: Boolean,
    enable_issue_dependencies: Boolean
) derives CirceEncoderObject,
      TapirSchema

//object InternalTracker {
// implicit val tapirSchema: Schema[InternalTracker] = tapir.schema.derived
// implicit val circeEnc: Encoder[InternalTracker]   = circe.encoder.deriveMagnoliaEncoder
// implicit val circeDec: Decoder[InternalTracker]   = circe.decoder.deriveMagnoliaDecoder
//}
