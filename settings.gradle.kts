pluginManagement {
    val kotlinVersion: String by settings
    val kspVersion: String by settings
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version kotlinVersion
        id("com.google.devtools.ksp") version "$kotlinVersion-$kspVersion"
    }
}

rootProject.name = "komapper-perf-test"
include("exposed")
include("komapper")
include("exposed")
include("komapper")
