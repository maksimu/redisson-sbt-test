

lazy val root = (project in file(".")).
  settings(
    name := "redisson-project",
    version := "1.0",
    scalaVersion := "2.11.11",
    mainClass in Compile := Some("redisson")
  )



// https://mvnrepository.com/artifact/org.redisson/redisson
libraryDependencies += "org.redisson" % "redisson" % "3.5.4"
libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"
libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.25" % "test"

//assemblyMergeStrategy in assembly := {
//  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
//  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
//  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
//  case PathList("com", "google", xs @ _*) => MergeStrategy.last
//  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
//  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
//  case PathList("io", "netty", xs @ _*) => MergeStrategy.last
//  case "about.html" => MergeStrategy.rename
//  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
//  case "META-INF/mailcap" => MergeStrategy.last
//  case "META-INF/mimetypes.default" => MergeStrategy.last
//  case "plugin.properties" => MergeStrategy.last
//  case "log4j.properties" => MergeStrategy.last
//  case x =>
//    val oldStrategy = (assemblyMergeStrategy in assembly).value
//    oldStrategy(x)
//}

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}