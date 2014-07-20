name := "myproject"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.18",
  "com.typesafe" %% "play-plugins-mailer" % "2.1-RC2"
)     

play.Project.playJavaSettings
