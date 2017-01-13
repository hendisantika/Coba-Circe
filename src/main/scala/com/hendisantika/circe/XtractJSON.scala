package com.hendisantika.circe

import io.circe.Json, io.circe.parser._
import cats.syntax.either._
import io.circe.optics.JsonPath._


/**
  * Created by hendisantika on 09/01/17.
  */
object CobaCirce4 extends App {
  //  val json: Json = parse("""
  //  {
  //    "responseHeader":{
  //      "status":0,
  //      "QTime":1,
  //      "params":{
  //      "indent":"true",
  //      "q":"content_t:ibadah &&\narticle_id_l:6729941",
  //      "wt":"json"}},
  //    "response":{"numFound":1,"start":0,"docs":[
  //    {
  //      "id":"comment:9404033",
  //      "comment_id_l":9404033,
  //      "article_id_l":6729941,
  //      "reply_to_id_l":0,
  //      "user_id_l":1686628,
  //      "username_s":"Maukayakerja",
  //      "email_s":"",
  //      "content_t":"Rajin ibadah.",
  //      "report_i":0,
  //      "type_s":"comment",
  //      "category_is":[71],
  //      "category_ss":["Politik"],
  //      "created_dt":"2016-05-19T02:12:01Z",
  //      "created_ts_l":1463623921,
  //      "is_deleted_i":0,
  //      "country_code_s":"id",
  //      "_version_":1534721405555310592}]
  //    }}""").getOrElse(Json.Null)

  val json: Json = parse(
    """
    {
      "order": {
        "customer": {
          "name": "Custy McCustomer",
          "contactDetails": {
            "address": "1 Fake Street, London, England",
            "phone": "0123-456-789"
          }
        },
        "items": [{
          "id": 123,
          "description": "banana",
          "quantity": 1
        }, {
          "id": 456,
          "description": "apple",
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
