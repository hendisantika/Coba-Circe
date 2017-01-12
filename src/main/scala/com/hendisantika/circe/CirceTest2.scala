package com.hendisantika.circe

/**
  * Created by hendisantika on 10/01/17.
  */
import io.circe._
import io.circe.optics.JsonPath._

object CirceTest2 extends App {
  val status = root.responseHeader.status.int
  val QTime = root.responseHeader.QTime.int
  val params = root.responseHeader.params.indent.string
  val q = root.responseHeader.params.q.string
  val wt = root.responseHeader.params.wt.string
  val num = root.response.numFound.int
  val start = root.response.start.int

  val input =
    """
 |     {
 |      "responseHeader":{
 |        "status":0,
 |        "QTime":1,
 |        "params":{
 |        "indent":"true",
 |        "q":"content_t:ibadah &&\narticle_id_l:6729941",
 |        "wt":"json"}},
 |      "response":{"numFound":1,"start":0,"docs":[
 |      {
 |        "id":"comment:9404033",
 |        "comment_id_l":9404033,
 |        "article_id_l":6729941,
 |        "reply_to_id_l":0,
 |        "user_id_l":1686628,
 |        "username_s":"Maukayakerja",
 |        "email_s":"",
 |        "content_t":"Rajin ibadah.",
 |        "report_i":0,
 |        "type_s":"comment",
 |        "category_is":[71],
 |        "category_ss":["Politik"],
 |        "created_dt":"2016-05-19T02:12:01Z",
 |        "created_ts_l":1463623921,
 |        "is_deleted_i":0,
 |        "country_code_s":"id",
 |        "_version_":1534721405555310592}]
 |      }}
    """.stripMargin
  parser.parse(input) match {
    case Left(a) => println(s"failed ${a}")
    case Right(json) =>
      val myId = status.getOption(json).get
      val myQ = QTime.getOption(json).get
      val myParams = params.getOption(json).get
      val qu = q.getOption(json).get
      val wt2 = wt.getOption(json).get
      val num2 = num.getOption(json).get
      val start2 = start.getOption(json).get

      println(s"id: ${myId} QTime: ${myQ} params: ${myParams} q: ${qu} wt: ${wt2}")
      println("Response : ")
      println(s"rows: ${num2}")
      println(s"start: ${start2}")
  }
}
