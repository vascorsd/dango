// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api

package object repo {
  type RepoOwner = Repository.Owner
  val RepoOwner: Repository.Owner.type = Repository.Owner
  type RepoName = Repository.Name
  val RepoName: Repository.Name.type = Repository.Name

  // available type classes for semi auto derivation:

  private[repo] type Schema[T] = sttp.tapir.Schema[T]
  private[repo] val schema = sttp.tapir.Schema

  private[repo] type Encoder[T] = io.circe.Encoder[T]
  private[repo] val circeEncoder = io.circe.magnolia.derivation.encoder.semiauto

  private[repo] type Decoder[T] = io.circe.Decoder[T]
  private[repo] val circeDecoder = io.circe.magnolia.derivation.decoder.semiauto
}
