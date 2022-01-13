package dango.gitea.api.repo

import derevo.circe.magnolia.decoder
import derevo.circe.magnolia.encoder
import derevo.derive
import sttp.tapir.derevo.schema

@derive(encoder, decoder, schema)
final case class InternalTracker(
    enable_time_tracker: Boolean,
    allow_only_contributors_to_track_time: Boolean,
    enable_issue_dependencies: Boolean
)
