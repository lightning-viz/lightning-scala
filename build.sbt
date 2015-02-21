name := "lightning-scala"

version := "0.1.0"

scalaVersion := "2.10.3"

libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "1.1.4"

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value

libraryDependencies += "org.specs2" %% "specs2" % "2.4.2" % "test"
