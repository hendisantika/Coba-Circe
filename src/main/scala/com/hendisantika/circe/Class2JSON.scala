package com.hendisantika.circe

import io.circe.generic.auto._
import io.circe.syntax._

/**
  * Created by hendisantika on 13/01/17.
  */

/*@JsonCodec */case class Shinobi(i: Int, s: String)

object Class2JSON extends App{
  val a = new Shinobi(13, "Uzumaki Naruto")
  val shinobi = a
  println(s"Asalnya --> $shinobi")
  println(s"To JSON --> ${shinobi.asJson.noSpaces}")


}



