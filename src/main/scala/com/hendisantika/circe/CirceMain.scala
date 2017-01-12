package com.hendisantika.circe

import io.circe.Encoder
import io.circe.syntax._

/**
  * Created by hendisantika on 09/01/17.
  */

object CirceMain extends App {
  val intsJson = List(1, 2, 3).asJson
  intsJson.as[List[Int]]
  println(intsJson)
}
