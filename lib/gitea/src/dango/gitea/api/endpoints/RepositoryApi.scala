package dango.gitea.api.endpoints

import dango.gitea.api._
import dango.gitea.api.repo._
import sttp.tapir._
import sttp.tapir.codec.newtype._
import sttp.tapir.json.circe.jsonBody
import Newtypes._

object RepositoryApi {
  private val repos = v1.in("repos")

  private val reposOwnerRepo = repos
    .in(path[Owner]("owner"))
    .in(path[RepoName]("repo"))

  private val releases = reposOwnerRepo.in("releases")

  // ############################################################   / repos / ...
  def repos_search(): Endpoint[Unit, Unit, Unit, SearchResults, Any] =
    repos.in("search").out(jsonBody[SearchResults])

  def repository_get(): PublicEndpoint[(Owner, RepoName), Unit, Repository, Any] =
    reposOwnerRepo.get.out(jsonBody[Repository])

  // ############################################################   / repos / ... / releases / ...
  def releases_list(): PublicEndpoint[(Owner, RepoName), Unit, List[Release], Any] =
    releases.get.out(jsonBody[List[Release]])

  def release_get(): PublicEndpoint[
    (Owner, RepoName, Release.Id),
    Unit,
    List[Release],
    Any
  ] = releases.in(path[Release.Id]("id")).get.out(jsonBody[List[Release]])
}
