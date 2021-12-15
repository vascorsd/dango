package dango
package gogs

import sttp.tapir._

object legacy {

  def oauth = endpoint
    .in(query[String]("client_id"))
    .in(query[String]("scopes"))
    .in(query[Option[String]]("state"))
    .in(query[Option[String]]("redirect_uri"))

  def ff = endpoint
}
