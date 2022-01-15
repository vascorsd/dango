package dango.gitea

import sttp.tapir._

package object api {
  // api versions available:
  private[api] val v1 = endpoint.in("api" / "v1")
}
