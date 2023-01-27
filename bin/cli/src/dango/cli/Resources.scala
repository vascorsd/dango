# SPDX-FileCopyrightText: 2023 Vasco Dias <m+git@vascorsd.com>
#
# SPDX-License-Identifier: AGPL-3.0-or-later

package dango.cli

import cats.effect._
import cats.implicits._
import sttp.capabilities.WebSockets
import sttp.capabilities.fs2.Fs2Streams
import sttp.client3.SttpBackend
import sttp.client3.httpclient.fs2.HttpClientFs2Backend

case class Resources[F[_]](
    sttpBackend1: SttpBackend[F, Fs2Streams[F] with WebSockets],
    sttpBackend2: SttpBackend[F, Fs2Streams[F] with WebSockets]
)

object Resources {
  def make[F[_]: Async](): Resource[F, Resources[F]] = {
    (
      HttpClientFs2Backend.resource[F](),
      HttpClientFs2Backend.resource[F]()
    ).mapN(Resources.apply)
  }

}
