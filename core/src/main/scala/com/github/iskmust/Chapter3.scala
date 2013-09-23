package com.github.iskmust

import scala.util.Random
import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}
import java.util
import scala.collection.mutable

/**
 * @author welcometo
 */
class Chapter3 {

  val n = 10

  //1
  val arr: Array[Int] = (for (i <- 0 until n) yield i) (collection.breakOut)

  val arr2 = new Array[Int](n)
  for (i <- 0 until n) arr2(i) = i

  println(arr2.mkString)

  //2
  for (i <- 0 until arr.length) {
    if (i < arr.length - 1 && i % 2 == 0) {
      val tmp = arr(i)
      arr(i) = arr (i + 1)
      arr(i + 1) = tmp
    }
  }
  println (arr.mkString)

  //3
  val arr3 = for (i <- 0 until arr2.length) yield {
    if (i < arr2.length - 1 && i % 2 == 0)
      arr2(i + 1)
    else
      arr2(i - 1)
  }
  println ("3: " + arr3.mkString)


  //4
  //val arr4: Array[Int]  = (1 to 10).map(_ * Random.nextInt()).toArray
  val arr4 = Array(1, -1, 5, 0, 7, -3, 6, -5 ,8, 10)
  println("Randomized: " + arr4.mkString)

  val arr4New = arr4.filter(_ > 0) ++  arr4.filter(_ <= 0)
  println("Sorted: " + arr4New.mkString)

  val arr4New1 = {
    (for (i <- arr4 if i > 0 ) yield i) ++ (for (i <- arr4 if i <= 0) yield i)
  }
  println("Arrnew1: " + arr4New1.mkString("(", ", ", ")"))

  //5
  println("Average: " + arr4New1.sum.toFloat / arr4New1.length)

  //6
  println("Sorted reverse" + arr4New1.sorted.reverse.mkString(" | "))

  //7
  arr4New1.distinct

  //9

  val sortedAmericaTimeZones = {
    (for (timeZone <- java.util.TimeZone.getAvailableIDs if timeZone.startsWith("America") ) yield {
      timeZone.drop(8)
    }).sorted
  }

  println(sortedAmericaTimeZones.mkString(" | "))

  //10

  val flawors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
  import scala.collection.JavaConversions._
  val flavor: mutable.Buffer[String] = flawors.getNativesForFlavor(DataFlavor.imageFlavor)
}
