package com.github.iskmust

import org.slf4j.LoggerFactory

import math._
import scala.util.Random

/**
 * @author welcometo
 */
class Chapter1 {
  val log = LoggerFactory.getLogger(getClass)

  //2
  log.debug(pow(sqrt(3), 2).toString)

  //5
  log.debug((10 max 2) toString)

  //6
  val a: BigInt = 2
  log.debug(a.pow(1024) toString)

  //7
  import BigInt._
  log.debug(probablePrime(12, Random) toString)

  //8
  log.debug(BigInt.apply(10, Random).toString(36))

  //9
  "string".head
  "String".last

}
