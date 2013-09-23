package com.github.iskmust

import scala.io.Source
import scala.collection.{mutable, SortedMap}

/**
 * @author welcometo
 */
class Chapter4 {

  //1
  val things = Map("Jeans" -> 10, "Shoes" -> 5, "TShirt" -> 20)
  val thingsWithDiscount = for ( (thing, price) <- things) yield (thing, price * 0.9)

  println(things)
  println(thingsWithDiscount)


  //2

  val words = Source.fromURL(Thread.currentThread().getContextClassLoader.getResource("words.txt")).mkString.split(" ")
  println(words.mkString(" | "))
  val mutableMap = scala.collection.mutable.Map[String, Int]();
  for (word <- words) {
    mutableMap(word) = mutableMap.getOrElse(word, 0) + 1
  }
  println(mutableMap)

  //3
  var immutableMap = Map[String, Int]()

  for (word <- words) {
    immutableMap = immutableMap + (word -> (immutableMap.getOrElse(word, 0) + 1))
  }


  //4
  var sortedMap: collection.Map[String, Int] = SortedMap[String, Int]()

  for (word <- words) {
    sortedMap = sortedMap + (word -> (sortedMap.getOrElse(word, 0) + 1))
  }
  println("Sorted" + sortedMap)

  //5
  import scala.collection.JavaConversions.mapAsScalaMap
  var treeMap: collection.Map[String, Int] = new java.util.TreeMap[String, Int]
  for (word <- words) {
    treeMap = treeMap + (word -> (treeMap.getOrElse(word, 0) + 1))
  }
  println(treeMap)

  //6
  val weekDays: collection.mutable.Map[String, Int] = mutable.LinkedHashMap[String, Int]()
  weekDays("Monday") = java.util.Calendar.MONDAY
  weekDays("Tuesday") = java.util.Calendar.TUESDAY
  weekDays("Thursday1121") = java.util.Calendar.THURSDAY

  println(weekDays)

  //7
  import scala.collection.JavaConversions.propertiesAsScalaMap
  val props: collection.Map[String, String] = System.getProperties
  println(props)

  val maxLength = props.keySet.maxBy(_.length).length

  val result = new StringBuilder
  val table = for((key, value) <- props) yield {
    result.clear
    val diff = maxLength - key.length
    result ++= key
    result ++=  " " * diff
    result ++= " | "
    result ++= value
    result ++= "\n"
    result.toString
  }

  println(table.mkString)

  //8

  def minmax(arr: Array[Int]): (Int, Int) = {
    (arr.min, arr.max)
  }

  println("MinMax: " + minmax(Array(1, 3, -5, 9, 4)))

  //9

  def lteqgt(arr: Array[Int], value: Int) = {
    val ltCount = arr.count(_ < value)
    val eqCount = arr.count(_ == value)
    val gtCount = arr.count(_ > value)

    (ltCount, eqCount, gtCount)
  }

  //10
  println("Hello".zip("World"))
}
