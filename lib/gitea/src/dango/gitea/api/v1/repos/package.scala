// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api.v1

package object repos {
  type Repo = (RepoOwner, RepoName)

  type RepoOwner = Repository.Owner
  val RepoOwner: Repository.Owner.type = Repository.Owner
  type RepoName = Repository.Name
  val RepoName: Repository.Name.type = Repository.Name
}
