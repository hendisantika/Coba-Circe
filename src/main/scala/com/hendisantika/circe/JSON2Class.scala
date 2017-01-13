package com.hendisantika.circe

import java.util.Date

import io.circe.generic.auto._
import io.circe.parser.decode

/**
  * Created by hendisantika on 09/01/17.
  * This is step to decode JSON Object into scala class
  */
object CobaCirce5 extends App {
  val rawJson: String =
    """
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


  val obj = decode[SolrDoc](rawJson)
  val solrDocument = obj match {
    case Right(x) => x
    case Left(x) => "document not found"
  }

  val solrDoc = solrDocument.asInstanceOf[SolrDoc]
  solrDoc.response.get.docs.map { doc =>
    CommentInsert(
      commentId = doc.comment_id_l,
      articleId = doc.article_id_l,
      replyTo = doc.reply_to_id_l,
      userId = doc.user_id_l,
      username = doc.username_s,
      email = doc.email_s,
      content = doc.content_t,
      created = new Date(doc.created_ts_l),
      numReport = doc.report_i,
      isDeleted = doc.is_deleted_i,
      isActivated = 1L)

      }

  println(solrDoc)

}
