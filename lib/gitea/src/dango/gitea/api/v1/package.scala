// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea.api

import sttp.tapir._

package object v1 {
  private[v1] val _v1 = endpoint.in("api" / "v1")
}
