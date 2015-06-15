name := "lightning-scala"

version := "0.1.1"

scalaVersion := "2.10.3"

homepage := Some(url("http://lightning-viz.org"))

description := "Scala client for interactive data visualization with Lightning."

organization := "org.viz.lightning"

organizationName := "lightning-viz"

organizationHomepage := Some(url("https://github.com/lightning-viz"))

libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "1.1.4"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.2.9"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1"

assemblyExcludedJars in assembly := { 
  val cp = (fullClasspath in assembly).value
  cp filter {_.data.getName == "IScala.jar"}
}
