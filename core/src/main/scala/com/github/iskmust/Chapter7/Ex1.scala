package com.github.iskmust.Chapter7

/**
 * @author welcometo
 */
class A(val b: Int)

package com {
  package github {
    package iskmust {
      package Chapter7 {
        class A
      }
    }
  }
}

object B {
  new A(2)
  new A()
}