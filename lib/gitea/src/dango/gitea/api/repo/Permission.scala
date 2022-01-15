package dango.gitea.api.repo

final case class Permission(
    admin: Boolean,
    push: Boolean,
    pull: Boolean
)

object Permission {
  implicit val tapirSchema: Schema[Permission] = schema.derived
  implicit val circeEnc: Encoder[Permission]   = circeEncoder.deriveMagnoliaEncoder
  implicit val circeDec: Decoder[Permission]   = circeDecoder.deriveMagnoliaDecoder
}
