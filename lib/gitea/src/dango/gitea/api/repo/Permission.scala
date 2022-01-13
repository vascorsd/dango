package dango.gitea.api.repo

import derevo.circe.magnolia.decoder
import derevo.circe.magnolia.encoder
import derevo.derive
import sttp.tapir.derevo.schema

@derive(encoder, decoder, schema)
final case class Permission(
    admin: Boolean,
    push: Boolean,
    pull: Boolean
)
