package com.hendisantika.circe

import io.circe.Decoder

/**
  * Created by hendisantika on 09/01/17.
  */
object CobaCirce extends App {
  val doc =
    """
    {
      "user": "some User",
      "parents": [{
        "url": "some url",
        "user": "some parent sha"
      }]
    }
    """

  case class User(value: String)

  object User {
    implicit val decodeSha: Decoder[User] = Decoder.instance(_.get[String]("user")).map(User(_))
  }

  case class Commit(user: User, parentUser: List[User])

  object Commit {
    implicit val decodeCommit: Decoder[Commit] = for {
      user <- Decoder[User]
      parents <- Decoder.instance(_.get[List[User]]("parents"))
    } yield Commit(user, parents)
  }

}
