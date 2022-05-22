package dango.internal

import scala.deriving.Mirror

private[dango] object derivation {
  type TapirSchema[T]     = sttp.tapir.Schema[T]
  type TapirCodecPlain[T] = sttp.tapir.Codec.PlainCodec[T]

  type CirceEncoderObject[T] = io.circe.Encoder.AsObject[T]
  type CirceEncoder[T]       = io.circe.Encoder[T]
  type CirceDecoder[T]       = io.circe.Decoder[T]

  object tapir {
    inline def schema[A: Mirror.Of]: TapirSchema[A] =
      sttp.tapir.Schema.derived
  }

  object circe {
    inline def encoder[A: Mirror.Of]: CirceEncoderObject[A] =
      io.circe.Encoder.AsObject.derived
    inline def decoder[A: Mirror.Of]: CirceDecoder[A] =
      io.circe.Decoder.derived

    // io.circe magnolia.derivation.encoder.semiauto // .deriveMagnoliaEncoder[T]
    // io.circe.magnolia.derivation.decoder.semiauto // .deriveMagnoliaDecoder[T]
  }
}
