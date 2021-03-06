package com.hendisantika.circe

import io.circe.Json, io.circe.parser._
import cats.syntax.either._
import io.circe.optics.JsonPath._


/**
  * Created by hendisantika on 09/01/17.
  */
object XtractJSON extends App {
  val json: Json = parse(
    """
    {
      "order": {
        "customer": {
          "name": "Hendi Santika",
          "contactDetails": {
            "address": "Gandaria Office Tower 8, Jln. Sultan Iskandar Muda Kebayoran Baru Jakarta Selatan Indonesia",
            "phone": "0123-456-789"
          }
        },
        "items": [{
          "id": 123,
          "description": "Xiaomi Note 3 Pro",
          "quantity": 1
        }, {
          "id": 456,
          "description": "Canon EOS M3",
          "quantity": 2
        }],
        "total": 123.45
      }
    }
    """).getOrElse(Json.Null)

  val phoneNum: Option[String] = json.hcursor.
    downField("order").
    downField("customer").
    downField("contactDetails").
    get[String]("phone").
    toOption
  // phoneNum: Option[String] = Some(0123-456-789)

  println(phoneNum)


  val _phoneNum = root.order.customer.contactDetails.phone.string
  // _phoneNum: monocle.Optional[io.circe.Json,String] = monocle.POptional$$anon$1@64ebbd87

  val phoneNum2: Option[String] = _phoneNum.getOption(json)
  // phoneNum: Option[String] = Some(0123-456-789)

  println("phoneNum2 --> " + phoneNum2)


}
