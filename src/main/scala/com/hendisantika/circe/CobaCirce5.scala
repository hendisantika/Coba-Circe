package com.hendisantika.circe


import java.util.Date

import cats.syntax.either._
import io.circe.{Decoder, DecodingFailure, HCursor, Json}
import io.circe.optics.JsonPath._
import io.circe.parser._
import com.hendisantika.circe._
import io.circe.generic.semiauto._

/**
  * Created by hendisantika on 09/01/17.
  */
object CobaCirce5 extends App {
    val json: Json = parse("""
    {
      "responseHeader":{
        "status":0,
        "QTime":1,
        "params":{
        "indent":"true",
        "q":"content_t:ibadah &&\narticle_id_l:6729941",
        "wt":"json"}},
      "response":{"numFound":1,"start":0,"docs":[
      {
        "id":"comment:9404033",
        "comment_id_l":9404033,
        "article_id_l":6729941,
        "reply_to_id_l":0,
        "user_id_l":1686628,
        "username_s":"Maukayakerja",
        "email_s":"",
        "content_t":"Rajin ibadah.",
        "report_i":0,
        "type_s":"comment",
        "category_is":[71],
        "category_ss":["Politik"],
        "created_dt":"2016-05-19T02:12:01Z",
        "created_ts_l":1463623921,
        "is_deleted_i":0,
        "country_code_s":"id",
        "_version_":1534721405555310592}]
      }}""").getOrElse(Json.Null)


  val json2: String = """
    {
      "responseHeader":{
        "status":0,
        "QTime":1,
        "params":{
        "indent":"true",
        "q":"content_t:ibadah &&\narticle_id_l:6729941",
        "wt":"json"}},
      "response":{"numFound":1,"start":0,"docs":[
      {
        "id":"comment:9404033",
        "comment_id_l":9404033,
        "article_id_l":6729941,
        "reply_to_id_l":0,
        "user_id_l":1686628,
        "username_s":"Maukayakerja",
        "email_s":"",
        "content_t":"Rajin ibadah.",
        "report_i":0,
        "type_s":"comment",
        "category_is":[71],
        "category_ss":["Politik"],
        "created_dt":"2016-05-19T02:12:01Z",
        "created_ts_l":1463623921,
        "is_deleted_i":0,
        "country_code_s":"id",
        "_version_":1534721405555310592}]
      }}"""


  //  val id: Option[String] = json.hcursor.
//    downField("response").
//    downField("docs").
//    get[String]("id").
//    toOption
//
//  println("id--> " + id)


  val _id = root.string
  val id2: Option[String] = _id.getOption(json)

  println("id --> " + id2)

//  val obj = decode[SolrDoc](json2)
//  match {
//    case Right(ok) => ok
//    case Left(failure) => println("Gagal --> " + failure)
//  }

//  val solrDocument = obj match {
//    case Xor.Right(r) => r
//    case Xor.Left(l) => "document not found"
//  }
//
//  solrDocument.response.get.docs.map { doc =>
//    CommentInsert(
//      commentId = doc.comment_id_l,
//      articleId = doc.article_id_l,
//      replyTo = doc.reply_to_id_l,
//      userId = doc.user_id_l,
//      username = doc.username_s,
//      email = doc.email_s,
//      content = doc.content_t,
//      created = new Date(doc.created_ts_l),
//      numReport = doc.report_i,
//      isDeleted = doc.is_deleted_i,
//      isActivated = 1L)
//  }



}
