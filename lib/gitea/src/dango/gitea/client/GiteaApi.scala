// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.client

import dango.gitea.api.v1.repos._
import dango.gitea.api.v1.endpoints._

import sttp.client3._
import sttp.model.Uri
import sttp.tapir.DecodeResult
import sttp.tapir.PublicEndpoint
import sttp.tapir.client.sttp._

final class GiteaApi[F[_], R](
    interpreter: SttpClientInterpreter,
    backend: SttpBackend[F, R],
    host: Uri
) {

  private def doHttpCall[I, E, O](e: PublicEndpoint[I, E, O, Any]) =
    interpreter.toClient(e, Some(host), backend)

  object repos {
    def info(
        repoOwner: RepoOwner,
        repoName: RepoName
    ): F[DecodeResult[Either[Unit, Repository]]] = {
      doHttpCall(RepositoryApi.repos.get)((repoOwner, repoName))
    }

    object releases {
      def list(
          repoOwner: RepoOwner,
          repoName: RepoName
      ): F[DecodeResult[Either[Unit, List[Release]]]] =
        doHttpCall(RepositoryApi.repos.releases.list)((repoOwner, repoName))
    }
  }

}

object GiteaApi {

  def makeWithInterpreter[F[_], R](
      interpreter: SttpClientInterpreter,
      backend: SttpBackend[F, R],
      host: Uri
  ): GiteaApi[F, R] =
    new GiteaApi[F, R](
      interpreter,
      backend,
      host
    )

  def make[F[_], R](
      backend: SttpBackend[F, R],
      host: Uri
  ): GiteaApi[F, R] =
    makeWithInterpreter[F, R](
      SttpClientInterpreter(),
      backend,
      host
    )
}
