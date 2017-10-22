name := "redisson-sbt-test"

version := "0.1"

scalaVersion := "2.12.4"

// https://mvnrepository.com/artifact/org.redisson/redisson
libraryDependencies += "org.redisson" % "redisson" % "3.5.4"


libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"
libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.25" % "test"

        