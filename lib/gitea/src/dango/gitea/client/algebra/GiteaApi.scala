// SPDX-FileCopyrightText: 2023 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.client.algebra
import cats.effect.IO
import dango.gitea.api.v1.repos._

trait GiteaApi[F[_], E[_]] {
  type RON = (RepoOwner, RepoName)

  trait Repo {
    def info(repo: Repo): F[E[Repository]]

    trait Releases {
      def list(repo: RON): F[E[List[Release]]]
    }
  }
}

object GiteaApiImpl extends GiteaApi[IO, Option] {}
