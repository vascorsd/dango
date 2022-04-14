// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api
package v1
package repos

import dango.internal.derivation._

final case class Repository(
    allow_merge_commits: Boolean,
    allow_rebase: Boolean,
    allow_rebase_explicit: Boolean,
    allow_squash_merge: Boolean,
    archived: Boolean,
    avatar_url: String,
    clone_url: String,
//created_at:	String($date-time),
    default_branch: String,
    default_merge_style: String,
    description: String,
    empty: Boolean,
//external_tracker:	ExternalTracker{...},
//external_wiki:	ExternalWiki{...},
    fork: Boolean,
    forks_count: Int,
    full_name: String,
    has_issues: Boolean,
    has_projects: Boolean,
    has_pull_requests: Boolean,
    has_wiki: Boolean,
    html_url: String,
    id: Int,
    ignore_whitespace_conflicts: Boolean,
    internal: Boolean,
    internal_tracker: InternalTracker,
    mirror: Boolean,
    mirror_interval: String,
    name: String,
    open_issues_count: Int,
    open_pr_counter: Int,
    original_url: String,
    owner: User,
//parent:	{...},
    permissions: Permission,
    `private`: Boolean,
    release_counter: Int,
    size: Int,
    ssh_url: String,
    stars_count: Int,
    template: Boolean,
//updated_at:	String($date-time),
    watchers_count: Int,
    website: String
)

object Repository {

  @io.estatico.newtype.macros.newtype
  final case class Owner(private val v: String)

  @io.estatico.newtype.macros.newtype
  final case class Name(private val v: String)

  @io.estatico.newtype.macros.newtype
  final case class Id(private val v: Int)

  object Id {
    implicit val tapirSchema: Schema[Id] = deriving
    implicit val circeEnc: Encoder[Id]   = deriving
    implicit val circeDec: Decoder[Id]   = deriving
  }

  implicit val tapirSchema: Schema[Repository] = tapir.schema.derived
  implicit val circeEnc: Encoder[Repository]   = circe.encoder.deriveMagnoliaEncoder
  implicit val circeDec: Decoder[Repository]   = circe.decoder.deriveMagnoliaDecoder
}
