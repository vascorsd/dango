package dango.gitea.api.endpoints

import sttp.tapir._

private[api] object Base {
  val api: Endpoint[Unit, Unit, Unit, Unit, Any] =
    endpoint.in("api" / "v1")
}
