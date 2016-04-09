name := "cavavin"

version := "0.1-ALPHA"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

libraryDependencies += "com.google.zxing" % "core" % "3.2.1"

libraryDependencies += "com.google.zxing" % "javase" % "3.2.1"

libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"
