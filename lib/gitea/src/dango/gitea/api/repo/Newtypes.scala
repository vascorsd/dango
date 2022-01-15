// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api.repo

object Newtypes {
  @io.estatico.newtype.macros.newtype
  final case class Owner(private val v: String)

  @io.estatico.newtype.macros.newtype
  final case class RepoName(private val v: String)
}
