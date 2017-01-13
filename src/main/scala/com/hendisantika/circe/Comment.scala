package com.hendisantika.circe

import java.util.Date

/**
  * Created by hendisantika on 09/01/17.
  */

case class SolrDoc(response: Option[SolrResponse])

case class SolrResponse(
                         numFound:Int,
                         start : Int,
                         docs : List[Comments]
                       )

case class Comments(
                     comment_id_l: Option[Long],
                     article_id_l: Long,
                     reply_to_id_l: Long,
                     user_id_l: Long,
                     username_s: Option[String],
                     email_s: Option[String],
                     content_t: String,
                     report_i: Long,
                     created_ts_l: Long,
                     is_deleted_i: Long
                   )

case class CommentInsert(
                          commentId: Option[Long],
                          articleId: Long,
                          replyTo: Long,
                          userId: Long,
                          username: Option[String],
                          email: Option[String],
                          content: String,
                          created: Date,
                          numReport: Long,
                          isDeleted: Long,
                          isActivated: Long
                        )


