package com.github.iskmust

import java.awt.Point

/**
 * @author welcometo
 */
class Chapter6 {

  //1,2
  class UnitConversions

  object InchesToCentimeters extends UnitConversions

  object GallonsToLiters extends UnitConversions

  //3
  object Origin extends Point

  //4
  class MyPoint(val x: Int, val y: Int)
  object MyPoint {
    def apply(x: Int, y: Int) = new MyPoint(x, y)
  }
  MyPoint(4, 4)

  // 6
  object Mast extends Enumeration {
    type Mast = Value

    val picky = Value("1")
    val chervy = Value("2")
    val buby = Value("3")
    val kresti = Value("4")
  }
  println(Mast.buby)

  //7

  def isRed1(mast: Mast.Value) = mast == Mast.chervy || mast == Mast.buby

  import Mast._
  def isRed(mast: Mast) = mast == chervy || mast == buby

  println("" + isRed(chervy)  + isRed(buby) + isRed(kresti) + isRed(picky))
}
