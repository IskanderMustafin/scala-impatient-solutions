package com.github.iskmust

import org.slf4j.LoggerFactory

/**
 * @author welcometo
 */
class Chapter2 {

  val log = LoggerFactory.getLogger(getClass)
  //1

  def getSignum(num: Int) = {
    if (num > 0) 1 else if (num < 0) -1 else 0
  }
  log.debug(getSignum(10).toString)
  log.debug(getSignum(-10).toString)
  log.debug(getSignum(0).toString)


  // 2
  val a = {}
  log.debug(a.equals(Unit).toString)

  //3
  var x: Unit = _
  var y = 4
  x = y = 1 // result of assignment y to 1 is Unit


  //4, 5
  def countDown(num: Int) {
    for (i <- num to 0 by -1)
      println(i)
  }
  countDown(10)

  //6

  var product:Long = 1;
  for (c <- "Hello2") {
    product *= c.toLong
  }

  println("Hello2".foldLeft(1L) {_ * _.toLong})

  def products(str: String, code: Long = 1): Long = str match {
    case "" => code
    case _ => products(str.tail, code * str.head.toLong)
  }


 // println("===Products: " + products("H"))

  println("=== PRODUCT " +products("Hello"))
}
