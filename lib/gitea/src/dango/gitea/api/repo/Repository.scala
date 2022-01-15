// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api.repo

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
  final case class RepositoryId(private val v: Int)
  object RepositoryId {
    implicit val tapirSchema: Schema[RepositoryId] = deriving
    implicit val circeEnc: Encoder[RepositoryId]   = deriving
    implicit val circeDec: Decoder[RepositoryId]   = deriving
  }

  implicit val tapirSchema: Schema[Repository] = schema.derived
  implicit val circeEnc: Encoder[Repository]   = circeEncoder.deriveMagnoliaEncoder
  implicit val circeDec: Decoder[Repository]   = circeDecoder.deriveMagnoliaDecoder
}
