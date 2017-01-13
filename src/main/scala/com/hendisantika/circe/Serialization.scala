package com.hendisantika.circe

/**
  * Created by hendisantika on 12/01/17.
  */
import java.io.FileOutputStream
import java.io.ObjectOutputStream

//@SerialVersionUID(15L)
//class Animal(name: String, age: Int) extends Serializable {
//  override def toString = s"Animal($name, $age)"
//}

//case class Person(name: String) extends Serializable

object MySerialize extends App {
  val fos = new FileOutputStream("../a.tmp")
  val oos = new ObjectOutputStream(fos)

  oos.writeObject(new Animal("Dvorak", 12))
  oos.writeObject(Person("Dijkstra"))
  oos.close
}
