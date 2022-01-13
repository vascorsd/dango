package dango.gitea.api.repo

import derevo.circe.magnolia.decoder
import derevo.circe.magnolia.encoder
import derevo.derive
import sttp.tapir.derevo.schema

@derive(encoder, decoder, schema)
final case class User(
    id: Int,
    login: String,
    full_name: String,
    email: String,
    avatar_url: String
)
