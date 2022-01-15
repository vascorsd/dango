// SPDX-FileCopyrightText: 2022 Vasco Dias <m+git@vascorsd.com>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package dango
package gogs

import sttp.tapir._

object legacy {

  def oauth: Endpoint[
    Unit,
    (String, String, Option[String], Option[String]),
    Unit,
    Unit,
    Any
  ] = endpoint
    .in(query[String]("client_id"))
    .in(query[String]("scopes"))
    .in(query[Option[String]]("state"))
    .in(query[Option[String]]("redirect_uri"))

  def ff = endpoint
}
