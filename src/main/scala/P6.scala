package org.tritsch.scala.ninetynine

/**
 * P6 - find out if a word is a palindrom.
 */

object P6 {
  final def isPalindrom(w: String): Boolean = {
    w.startsWith(w.drop(w.length/2).reverse)
  }

  final def isPalindrom2(w: String): Boolean = {
    w.equals(w.reverse)
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length == 1, "Need 1 parameter - Usage: P6 <word>")
    println(isPalindrom(args(0)))
    println(isPalindrom2(args(0)))
  } 
}
