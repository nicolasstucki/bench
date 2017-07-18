scalaVersion := "0.2.0-RC1"

packSettings
enablePlugins(JmhPlugin)

libraryDependencies ++= Seq(
  ("org.scala-lang" % "scala-reflect" % "2.11.11").withDottyCompat(), // old version of dotty depends on it
  "ch.epfl.lamp" %% "dotty" % "0.2.0-RC1"
)

mainClass in (Jmh, run) := Some("dotty.tools.benchmarks.Bench")  // custom main for jmh:run

publishArtifact := false

packMain := Map("bench" -> "dotty.tools.benchmarks.Bench")

packGenerateWindowsBatFile := false

packExpandedClasspath := true

packBashTemplate := baseDirectory.value + "/templates/launch.mustache"
