// SPDX-FileCopyrightText: 2023 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango.cli

sealed trait Platform extends Product with Serializable {
  def name: String
}

object Platform {
  case object Github    extends Platform { val name = "github"    }
  case object Gitlab    extends Platform { val name = "gitlab"    }
  case object Gitea     extends Platform { val name = "gitea"     }
  case object Gogs      extends Platform { val name = "gogs"      }
  case object Sourcehut extends Platform { val name = "sourcehut" }

  val values: List[Platform] = {
    Github :: Gitlab :: Gitea :: Gogs :: Sourcehut ::
      Nil
  }

  val names: List[String] = {
    values.map(_.name)
  }

  def from(name: String): Option[Platform] = {
    values.find(_.name == name)
  }

}
