plugins {
    java
    kotlin("jvm")
    kotlin("plugin.allopen")
    id("org.jetbrains.kotlinx.benchmark")
    id("com.diffplug.spotless") version "6.15.0"
}

val kotlinxBenchmarkVersion: String by project
val ktlintVersion: String by project

allprojects {
    apply(plugin = "base")
    apply(plugin = "com.diffplug.spotless")

    repositories {
        mavenCentral()
    }

    spotless {
        kotlinGradle {
            ktlint(ktlintVersion)
        }
    }

    tasks {
        build {
            dependsOn(spotlessApply)
        }
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
            vendor.set(JvmVendorSpec.ADOPTIUM)
        }
    }

    spotless {
        kotlin {
            ktlint(ktlintVersion)
            targetExclude("build/**")
        }
    }
}

configure(subprojects - project(":common")) {
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
    apply(plugin = "org.jetbrains.kotlinx.benchmark")

    dependencies {
        implementation(project(":common"))
        implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:$kotlinxBenchmarkVersion")
    }

    allOpen {
        annotation("org.openjdk.jmh.annotations.State")
    }

    benchmark {
        configurations {
            named("main") {
                warmups = 3 // number of warmup iterations
                iterations = 5 // number of iterations
                iterationTime = 3 // time in seconds per iteration
            }
        }
        targets {
            register("main") {
                this as kotlinx.benchmark.gradle.JvmBenchmarkTarget
                jmhVersion = "1.36"
            }
        }
    }
}
