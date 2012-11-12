package org.tritsch.scala.ninetynine

/**
 * P11 - modified run-length encoding
 */

object P11 {
  final def encodeModified(l: List[Any]): List[Any] = {
    List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  }
}
