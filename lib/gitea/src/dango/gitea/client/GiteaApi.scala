package dango.gitea.client

import dango.gitea.api._
import dango.gitea.api.repo._
import dango.gitea.api.repo.Newtypes.{Owner, RepoName}
import sttp.client3._
import sttp.model.Uri
import sttp.tapir.DecodeResult
import sttp.tapir.PublicEndpoint
import sttp.tapir.client.sttp._

private[gitea] class GiteaApi[F[_], R](
    host: Uri,
    interpreter: SttpClientInterpreter,
    backend: SttpBackend[F, R]
) {

  private def doHttpCall[I, E, O](e: PublicEndpoint[I, E, O, Any]) =
    interpreter.toClient(e, Some(host), backend)

  object repos {
    def info(
        owner: Owner,
        repoName: RepoName
    ): F[DecodeResult[Either[Unit, Repository]]] =
      doHttpCall(endpoints.RepositoryApi.repository_get())((owner, repoName))

    object releases {
      def list(
          owner: Owner,
          repoName: RepoName
      ): F[DecodeResult[Either[Unit, List[Release]]]] =
        doHttpCall(endpoints.RepositoryApi.releases_list())((owner, repoName))
    }
  }

}

object GiteaApi {
  def make[F[_], R](
      host: Uri,
      sttpBackend: SttpBackend[F, R]
  ): GiteaApi[F, R] =
    new GiteaApi[F, R](
      host,
      SttpClientInterpreter(),
      sttpBackend
    )

  def makeWithInterpreter[F[_], R](
      host: Uri,
      sttpBackend: SttpBackend[F, R],
      interpreter: SttpClientInterpreter
  ): GiteaApi[F, R] =
    new GiteaApi[F, R](
      host,
      interpreter,
      sttpBackend
    )
}
