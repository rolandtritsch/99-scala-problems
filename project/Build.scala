package org.tritsch.scala.ninetynine.build

import sbt._
import sbt.Keys._

import org.ensime.sbt.Plugin.Settings._
import org.ensime.sbt.util.SExp._

object Build extends sbt.Build {
  override val settings = super.settings ++ Seq(
    ensimeConfig := sexp(
      key(":compile-deps"), sexp("/Users/rtritsch/.ivy2/cache/org.scalatest/scalatest_2.9.2/jars/scalatest_2.9.2-1.8.jar")
    ),

    organization := "org.tritsch.scala.ninetynine",
    name := "99 Scala Problems",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.9.2",

    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "1.8" % "test"
    )

    // testOptions in Test += Tests.Argument("-l", "ExtendedTest")
  )

  lazy val root = Project("root", file("."))
}
