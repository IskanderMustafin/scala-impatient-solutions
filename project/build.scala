import sbt._
import Keys._

object RoygbivBuild extends Build {
  val Organization = "com.github.iskmust"
  val Name = "scala-impatient-solutions"
  val Version      = "1.0.0-SNAPSHOT"
  val ScalaVersion = "2.10.2"

  lazy val parentSettings = buildSettings

  lazy val scalaImpatient = Project(
    id = "scala-impatient",
    base = file("."),
    settings = parentSettings,
    aggregate = Seq(shared, core)
  )

  lazy val shared = Project(
    id = "shared",
    base = file("shared"),
    settings = defaultSettings ++ Seq(libraryDependencies ++= Dependencies.scalaImpatient)
  )

  lazy val core = Project(
    id = "core",
    base = file("core"),
    dependencies = Seq(shared),
    settings = defaultSettings ++ Seq(
      libraryDependencies ++= Dependencies.scalaImpatient
    )
  )

  lazy val web = Project(
    id = "web",
    base = file("web"),
    dependencies = Seq(shared),
    settings = defaultSettings ++ Seq(libraryDependencies ++= Dependencies.scalaImpatient /*++ Dependencies.sprayLibs*/)
  )

  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := Organization,
    name         := Name,
    version      := Version,
    scalaVersion := ScalaVersion
  )

  lazy val defaultSettings = buildSettings ++ Seq(
    // compile options
    scalacOptions ++= Seq("-encoding", "UTF-8", "-optimise", "-deprecation", "-unchecked"),
    // disable parallel tests
    parallelExecution in Test := false
  )
}

object Dependencies {
  import Dependency._

  val scalaImpatient = Seq(slf4j, logback, scalatest)

  //val sprayLibs = Seq(play)

}

object Dependency {

  object Version {
    val Scalatest = "1.9.1"
    val Slf4j     = "1.7.5"
    val Logback   = "1.0.13"
  }

  val slf4j         = "org.slf4j"                 % "slf4j-api"           % Version.Slf4j
  val logback       = "ch.qos.logback"            % "logback-classic"     % Version.Logback

  // ---- Test dependencies ----
  val scalatest     = "org.scalatest"            %% "scalatest"           % Version.Scalatest 	 % "test"
}
