package dango.gitea

import sttp.tapir._
import sttp.tapir.json.circe._

object api {
  private val base = endpoint.in("api" / "v1")

  object repo {
    private val baseRepos = base.in("repos")

    type Owner = String
    type Repo  = String

    val getRepo: PublicEndpoint[(Owner, Repo), Unit, Repository, Any] =
      baseRepos.get
        .in(path[Owner]("owner"))
        .in(path[Repo]("repo"))
        .out(jsonBody[Repository])

  }
}
