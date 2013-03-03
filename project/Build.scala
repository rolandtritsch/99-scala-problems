package org.tritsch.scala.ninetynine.build

import sbt._
import sbt.Keys._

import org.ensime.sbt.Plugin.Settings._
import org.ensime.sbt.util.SExp._

object Build extends sbt.Build {
  val scalaVersionSetting = "2.9.2"
  val scalaTestVersionSetting = "1.8"
  override val settings = super.settings ++ Seq(
    ensimeConfig := sexp(
      key(":compile-deps"), sexp("/Users/rtritsch/.ivy2/cache/org.scalatest/scalatest_" + scalaVersionSetting + "/jars/scalatest_" + scalaVersionSetting + "-" + scalaTestVersionSetting + ".jar")
    ),

    organization := "org.tritsch.scala.ninetynine",
    name := "99 Scala Problems",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := scalaVersionSetting,

    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % scalaTestVersionSetting % "test"
    )

    // testOptions in Test += Tests.Argument("-l", "ExtendedTest")
  )

  lazy val root = Project("root", file("."))
}
