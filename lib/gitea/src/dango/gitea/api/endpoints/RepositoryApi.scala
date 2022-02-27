// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api.endpoints

import dango.gitea.api._
import dango.gitea.api.repo._

import sttp.tapir._
import sttp.tapir.codec.newtype._
import sttp.tapir.json.circe.jsonBody

object RepositoryApi {
  private val repos = v1
    .in("repos")

  private val reposOwnerRepo = repos
    .in(path[RepoOwner]("owner"))
    .in(path[RepoName]("repo"))

  private val releases = reposOwnerRepo
    .in("releases")

  def repos_search(): Endpoint[Unit, Unit, Unit, SearchResults, Any] =
    repos.in("search").out(jsonBody[SearchResults])

  def repository_get(): PublicEndpoint[(RepoOwner, RepoName), Unit, Repository, Any] =
    reposOwnerRepo.get.out(jsonBody[Repository])

  def releases_list(): PublicEndpoint[(RepoOwner, RepoName), Unit, List[Release], Any] =
    releases.get.out(jsonBody[List[Release]])

  def release_get(): PublicEndpoint[
    (RepoOwner, RepoName, Release.Id),
    Unit,
    List[Release],
    Any
  ] = releases.in(path[Release.Id]("id")).get.out(jsonBody[List[Release]])
}
