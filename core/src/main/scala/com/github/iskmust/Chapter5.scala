package com.github.iskmust

import scala.beans.BeanProperty

/**
 * @author welcometo
 */
class Chapter5 {

  //1
  class Counter {
    private var value: Int = _

    def increment() = if (value != Int.MaxValue) value += 1


    def current = value
  }

  //2

  class BankAccount(private var _balance: Int) {

    def balance = _balance

    def deposit(value: Int) =  _balance += value

    def withDraw(value: Int) = _balance -= value

  }

  //3
  class Time(val hours: Int, val minutes: Byte) {

    private val asMinutes = hours * 60 + minutes

    def before(other: Time): Boolean = {
      asMinutes < other.asMinutes
    }
  }

  println(new Time(1, 25).before(new Time(1, 25)))

  //4
  class Student(@BeanProperty var name: String, @BeanProperty var id: Long)

  val s = new Student("Mew", 1234)
  s.setId(12345)
  s.getName

  //5
  class Person(var age: Int) {
    if (age < 0) age = 0
  }

  //6
  class Person2(firstLast: String) {
    val (first, last) = firstLast.splitAt(firstLast.indexOf(" "))
  }

  val p2 = new Person2("Erick Smith")

  println(p2.first + " AND " + p2.last)

  //7
  class Car(val creator: String, val model: String, val year: Int = -1, var regNumber: String = "")

  class Employee {

    val name: String = ""
    var salary: Double = _
  }

  new Employee()
}

