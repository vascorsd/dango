package dango.gitea.api.repo

import derevo.circe.magnolia.decoder
import derevo.circe.magnolia.encoder
import derevo.derive
import sttp.tapir.derevo.schema

@derive(encoder, decoder, schema)
final case class Release(
    id: Int,
    name: String,
    body: String,
    author: User,
    draft: Boolean,
    prerelease: Boolean,
    tag_name: String,
    url: String,
    zipball_url: String,
    tarball_url: String,
    target_commitish: String,
    html_url: String
)
