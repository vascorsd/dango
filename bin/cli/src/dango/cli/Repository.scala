// SPDX-FileCopyrightText: 2023 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.cli

case class Repository(owner: Repository.Owner, repo: Repository.Name)

object Repository {
  @io.estatico.newtype.macros.newtype
  final case class Owner(v: String)

  @io.estatico.newtype.macros.newtype
  final case class Name(v: String)
}
