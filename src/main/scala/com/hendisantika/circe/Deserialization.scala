package com.hendisantika.circe

import java.io.{FileInputStream, ObjectInputStream}

/**
  * Created by hendisantika on 12/01/17.
  */

@SerialVersionUID(15L)
class Animal(name: String, age: Int) extends Serializable {
  override def toString = s"Animal($name, $age)"
}

case class Person(name: String)

// or fork := true in sbt
class ObjectInputStreamWithCustomClassLoader(
                                              fileInputStream: FileInputStream
                                            ) extends ObjectInputStream(fileInputStream) {
  override def resolveClass(desc: java.io.ObjectStreamClass): Class[_] = {
    try {
      Class.forName(desc.getName, false, getClass.getClassLoader)
    }
    catch {
      case ex: ClassNotFoundException => super.resolveClass(desc)
    }
  }
}

object MyDeserialize extends App {
  val fis = new FileInputStream("../a.tmp")
  val ois = new ObjectInputStreamWithCustomClassLoader(fis)

  val animal = ois.readObject
  val person = ois.readObject
  ois.close
  println(animal)
  println(person)
}
