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
