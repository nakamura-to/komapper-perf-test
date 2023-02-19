import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm")
    id("com.diffplug.spotless")version "6.15.0"
}

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

    dependencies {
        testImplementation(kotlin("test"))
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
            vendor.set(JvmVendorSpec.ADOPTIUM)
        }
    }

    tasks {
        withType<Test>().configureEach {
            useJUnitPlatform()
        }
    }

    spotless {
        kotlin {
            ktlint(ktlintVersion)
            targetExclude("build/**")
        }
    }
}
