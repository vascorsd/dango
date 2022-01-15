package dango.gitea.api

package object repo {
  // available type classes for semi auto derivation:

  private[repo] type Schema[T] = sttp.tapir.Schema[T]
  private[repo] val schema = sttp.tapir.Schema

  private[repo] type Encoder[T] = io.circe.Encoder[T]
  private[repo] val circeEncoder = io.circe.magnolia.derivation.encoder.semiauto

  private[repo] type Decoder[T] = io.circe.Decoder[T]
  private[repo] val circeDecoder = io.circe.magnolia.derivation.decoder.semiauto

}