package dango.gitea.api.repo

final case class InternalTracker(
    enable_time_tracker: Boolean,
    allow_only_contributors_to_track_time: Boolean,
    enable_issue_dependencies: Boolean
)

object InternalTracker {
  implicit val tapirSchema: Schema[InternalTracker] = schema.derived
  implicit val circeEnc: Encoder[InternalTracker]   = circeEncoder.deriveMagnoliaEncoder
  implicit val circeDec: Decoder[InternalTracker]   = circeDecoder.deriveMagnoliaDecoder
}
