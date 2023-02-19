pluginManagement {
    val kotlinVersion: String by settings
    val kspVersion: String by settings
    val kotlinxBenchmarkVersion: String by settings
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.allopen") version kotlinVersion
        id("com.google.devtools.ksp") version "$kotlinVersion-$kspVersion"
        id("org.jetbrains.kotlinx.benchmark") version kotlinxBenchmarkVersion
    }
}

rootProject.name = "komapper-perf-test"
include("common")
include("exposed")
include("komapper")
include("ktorm")
