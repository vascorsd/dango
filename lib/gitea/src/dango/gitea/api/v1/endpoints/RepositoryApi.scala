// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api.v1
package endpoints

import dango.gitea.api.v1.repos._
import sttp.tapir._
import sttp.tapir.codec.newtype._
import sttp.tapir.json.circe.jsonBody

trait RepositoryApi {

  object repos {
    private val _repos = _v1.in("repos")
    private val _reposParams =
      _repos
        .in(path[RepoOwner]("owner"))
        .in(path[RepoName]("repo"))

    // --- /v1/repos/search
    val search: Endpoint[Unit, Unit, Unit, SearchResults, Any] =
      _repos
        .in("search")
        .out(jsonBody[SearchResults])

    // --- /v1/repos/{owner}/{repo}
    val get: Endpoint[Unit, (RepoOwner, RepoName), Unit, Repository, Any] =
      _reposParams.get
        .out(jsonBody[Repository])

    object releases {
      private val _releases = _reposParams.in("releases")

      // --- /v1/repos/{owner}/{repo}/releases
      val list: Endpoint[Unit, (RepoOwner, RepoName), Unit, List[Release], Any] =
        _releases.get
          .out(jsonBody[List[Release]])

      // --- /v1/repos/{owner}/{repo}/releases/{id}
      val get
          : Endpoint[Unit, (RepoOwner, RepoName, Release.Id), Unit, List[Release], Any] =
        _releases.get
          .in(path[Release.Id]("id"))
          .out(jsonBody[List[Release]])
    }
  }

}

object RepositoryApi extends RepositoryApi
