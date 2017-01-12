package com.hendisantika.circe

/**
  * Created by hendisantika on 09/01/17.
  */

import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
// import io.circe._
// import io.circe.generic.auto._
// import io.circe.parser._
// import io.circe.syntax._

object CobaCirce3 extends App {

  sealed trait Foo

  // defined trait Foo

  case class Bar(xs: List[String]) extends Foo

  // defined class Bar

  case class Qux(i: Int, d: Option[Double]) extends Foo

  // defined class Qux

  val foo: Foo = Qux(13, Some(14.0))
  // foo: Foo = Qux(13,Some(14.0))

  foo.asJson.noSpaces
  // res0: String = {"Qux":{"i":13,"d":14.0}}

  decode[Foo](foo.asJson.spaces4)
  // res1: Either[io.circe.Error,Foo] = Right(Qux(13,Some(14.0)))

}
