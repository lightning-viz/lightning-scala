name := "lightning-scala"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.3"

homepage := Some(url("http://lightning-viz.org"))

description := "Scala client for interactive data visualization with Lightning."

organization := "org.lightning-viz"

organizationName := "lightning-viz"

organizationHomepage := Some(url("https://github.com/lightning-viz"))

libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "1.1.4"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.2.9"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1"

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://lightning-viz.org</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>http://opensource.org/licenses/MIT</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:lightning-viz/lightning-scala.git</url>
      <connection>scm:git:git@github.com:lightning-viz/lightning-scala.git</connection>
    </scm>
    <developers>
      <developer>
        <id>freeman-lab</id>
        <name>Jeremy Freeman</name>
        <url>http://github.com/freeman-lab</url>
      </developer>
      <developer>
        <id>mathisonian</id>
        <name>Matthew Conlen</name>
        <url>http://github.com/mathisonian</url>
      </developer>
    </developers>)