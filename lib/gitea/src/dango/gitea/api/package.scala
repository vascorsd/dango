// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.gitea

import sttp.tapir._

package object api {
  // api versions available:
  private[api] val v1 = endpoint.in("api" / "v1")
}
