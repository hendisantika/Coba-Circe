package com.hendisantika.circe

/**
  * Created by hendisantika on 09/01/17.
  */

case class SolrDoc(response: Option[SolrResponse])

case class SolrResponse(
                       numFound:Int,
                       start : Int,
                       docs : List[Docs]
                       )

case class Docs(
                        id: String,
                        comment_id_l: Option[Long],
                        article_id_l: Option[Long],
                        reply_to_id_l: Option[Long],
                        user_id_l: Option[Long],
                        username_s: Option[String],
                        email_s: Option[String],
                        content_t: String,
                        report_i: Option[Int],
                        type_s: Option[String],
                        category_is: List[Int],
                        category_ss: List[String],
                        created_dt: Option[String],
                        created_ts_l: Option[Long],
                        is_deleted_i: Option[Int],
                        country_code_s: Option[String],
                        version: Option[Long]
                      )

case class CommentInsert(
    commentId: Option[String],
    articleId: Option[String],
    replyTo: Option[String],
    userId: Option[String],
    username: Option[String],
    email: Option[String],
    content: Option[String],
    created: Option[String],
    numReport: Option[String],
    isDeleted: Option[String]
)

