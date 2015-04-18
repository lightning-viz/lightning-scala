name := "lightning-scala"

version := "0.1.0"

scalaVersion := "2.10.3"

homepage := Some(url("http://lightning-viz.org"))

description := "Scala client for interactive data visualization with Lightning."

organization := "org.lightning-viz"

organizationName := "lightning-viz"

organizationHomepage := Some(url("https://github.com/lightning-viz"))

libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "1.1.4"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.2.9"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1"
