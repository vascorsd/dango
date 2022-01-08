package dango.gitea.client

import dango.gitea.api._
import sttp.client3._
import sttp.model.Uri
import sttp.tapir.client.sttp._
import sttp.tapir.{DecodeResult, PublicEndpoint}

private[gitea] class GiteaApi[F[_], R](
    host: Uri,
    interpreter: SttpClientInterpreter,
    backend: SttpBackend[F, R]
) {

  private def doHttpCall[I, E, O](e: PublicEndpoint[I, E, O, Any]) =
    interpreter.toClient(e, Some(host), backend)

  def repository(
      owner: Owner,
      repoName: RepoName
  ): F[DecodeResult[Either[Unit, Repository]]] =
    doHttpCall(endpoints.RepositoryApi.repositoryGet)((owner, repoName))
}

object GiteaApi {
  def apply[F[_], R](
      host: Uri,
      sttpBackend: SttpBackend[F, R],
      interpreter: SttpClientInterpreter = SttpClientInterpreter()
  ): GiteaApi[F, R] =
    new GiteaApi[F, R](
      host,
      interpreter,
      sttpBackend
    )
}
