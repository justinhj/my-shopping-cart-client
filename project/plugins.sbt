resolvers ++= Seq(
    Classpaths.typesafeReleases,
    Classpaths.sbtPluginReleases,
    "jgit-repo" at "http://download.eclipse.org/jgit/maven",
    "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"
  )

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.28")

libraryDependencies += "com.thesamet.scalapb" %% "compilerplugin" % "0.10.1"