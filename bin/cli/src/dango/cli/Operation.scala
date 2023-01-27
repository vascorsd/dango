# SPDX-FileCopyrightText: 2023 Vasco Dias <m+git@vascorsd.com>
#
# SPDX-License-Identifier: AGPL-3.0-or-later

package dango.cli

sealed trait Operation extends Product with Serializable
object Operation {
  case object Repo {
    case object Info     extends Operation
    case object Releases extends Operation
  }
}
