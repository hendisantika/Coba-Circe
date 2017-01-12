package com.hendisantika.circe

/**
  * Created by hendisantika on 10/01/17.
  */
import io.circe._
import io.circe.optics.JsonPath._

object CirceTest1  extends App {
  val id = root.id.long
  val date = root.date.long

  val input =
    """
      |{
      |  "id" : 0,
      |  "memberIds" : [
      |    11, 12, 13
      |  ],
      |  "date" : 1484183596
      |}
    """.stripMargin
  parser.parse(input) match {
    case Left(a) => println(s"failed ${a}")
    case Right(json) =>
      val myId = id.getOption(json).get
      val myDate = date.getOption(json).get
      println(s"id: ${myId} date: ${myDate}")
  }
}
