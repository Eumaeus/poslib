name := "Cross-compiled Part of Speech library"

// Depends on libraries that only work under 2.12?
crossScalaVersions in ThisBuild := Seq( "2.12.4")
scalaVersion := (crossScalaVersions in ThisBuild).value.last

lazy val root = project.in(file(".")).
    aggregate(crossedJVM, crossedJS).
    settings(
      publish := {},
      publishLocal := {}

    )

val circeVersion = "0.9.0"


lazy val crossed = crossProject.in(file(".")).
    settings(
      name := "poslib",
      organization := "edu.furman.classics",
      version := "0.1.0",
      licenses += ("GPL-3.0",url("https://opensource.org/licenses/gpl-3.0.html")),
      resolvers += Resolver.jcenterRepo,
      resolvers += Resolver.bintrayRepo("eumaeus", "maven"),
      retrieveManaged := true,
      libraryDependencies ++= Seq(
        "org.scala-js" %% "scalajs-stubs" % scalaJSVersion % "provided",
        "org.scalatest" %%% "scalatest" % "3.0.1" % "test",
      ),
      libraryDependencies ++= Seq(
        "io.circe" %%% "circe-core",
        "io.circe" %%% "circe-generic",
        "io.circe" %%% "circe-optics",
        "io.circe" %%% "circe-parser"
      ).map(_ % circeVersion)
    ).
    jvmSettings(
      tutTargetDirectory := file("docs"),
      tutSourceDirectory := file("shared/src/main/tut")
    ).
    jsSettings(
      skip in packageJSDependencies := false,
      scalaJSUseMainModuleInitializer in Compile := true
    )

lazy val crossedJVM = crossed.jvm.enablePlugins(TutPlugin)
lazy val crossedJS = crossed.js
