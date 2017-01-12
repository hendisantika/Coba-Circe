package com.hendisantika.circe

import java.time.{Instant, ZoneOffset, ZonedDateTime}
import java.util.Date

import cats.syntax.either._
import io.circe.{Decoder, Encoder}
import io.circe._, io.circe.generic.semiauto._

/**
  * Created by amura on 12/26/16.
  */
object Implicits {
  implicit val encodeInstant: Encoder[ZonedDateTime] = Encoder.encodeLong.contramap[ZonedDateTime](_.toEpochSecond)

  implicit val decodeInstant: Decoder[ZonedDateTime] = Decoder.decodeLong.emap { ts =>
    Either.catchNonFatal(ZonedDateTime.ofInstant(Instant.ofEpochSecond(ts), ZoneOffset.UTC)).leftMap(t => "ZonedDateTime")
  }

  implicit val encodeDate: Encoder[Date] = Encoder.encodeLong.contramap[Date](_.getTime)

  implicit val decodeDate: Decoder[Date] = Decoder.decodeLong.emap { ts =>
    Either.catchNonFatal(new Date(ts)).leftMap(t => "Date")
  }

  implicit val comDecoder: Decoder[Comments] = deriveDecoder[Comments]



}
