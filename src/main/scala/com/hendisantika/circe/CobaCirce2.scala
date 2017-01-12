package com.hendisantika.circe

/**
  * Created by hendisantika on 09/01/17.
  */

import io.circe._
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe._
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe._, io.circe.parser._

object CobaCirce2 extends App {
  //  val rawJson =
  //    """
  //      |{"hello": "world",
  //      |"age": 42,
  //      |"nested":
  //      |{ "deeper":
  //      |{ "treasure": true }}}""".stripMargin
  //  parse(rawJson).getOrElse(Json.empty)

  val rawJson: String =
    """
    {
      "foo": "bar",
      "baz": 123,
      "list of stuff": [ 4, 5, 6 ]
    }
    """
  // rawJson: String =
  // "
  // {
  //   "foo": "bar",
  //   "baz": 123,
  //   "list of stuff": [ 4, 5, 6 ]
  // }
  // "

  val parseResult = parse(rawJson)
  match {
    case Left(failure) => println("Invalid JSON :()")
    case Right(json) => println("Yay, got some JSON!")
  }
  // parseResult: Either[io.circe.ParsingFailure,io.circe.Json] =
  // Right({
  //   "foo" : "bar",
  //   "baz" : 123,
  //   "list of stuff" : [
  //     4,
  //     5,
  //     6
  //   ]
  // })

  println(parseResult)
}
