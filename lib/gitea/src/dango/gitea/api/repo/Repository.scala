package dango.gitea.api.repo

import derevo.circe.magnolia.decoder
import derevo.circe.magnolia.encoder
import derevo.derive
import sttp.tapir.derevo.schema

@derive(encoder, decoder, schema)
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
//forks_count:	integer($int64),
    full_name: String,
    has_issues: Boolean,
    has_projects: Boolean,
    has_pull_requests: Boolean,
    has_wiki: Boolean,
    html_url: String,
//id:	integer($int64),
    ignore_whitespace_conflicts: Boolean,
    internal: Boolean,
//internal_tracker:	InternalTracker{...},
    mirror: Boolean,
    mirror_interval: String,
    name: String,
//open_issues_count:	integer($int64),
//open_pr_counter:	integer($int64),
    original_url: String,
//owner:	User{...},
//parent:	{...},
//permissions:	Permission{...},
//private:	Boolean,
//release_counter:	integer($int64),
//size:	integer($int64),
    ssh_url: String,
//stars_count:	integer($int64),
    template: Boolean,
//updated_at:	String($date-time),
//watchers_count:	integer($int64),
    website: String
)
