package dango.gitea.api.endpoints

import dango.gitea.api.repo.Repository
import dango.gitea.api.{Owner, RepoName}
import sttp.tapir._
import sttp.tapir.codec.newtype._
import sttp.tapir.json.circe.jsonBody

object RepositoryApi {
  private[api] def repos = Base.api.in("repos")

  def repositoryGet: PublicEndpoint[(Owner, RepoName), Unit, Repository, Any] =
    repos.get
      .in(path[Owner]("owner"))
      .in(path[RepoName]("repo"))
      .out(jsonBody[Repository])
}
