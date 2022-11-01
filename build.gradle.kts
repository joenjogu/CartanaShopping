buildscript {
    repositories {
        google()
        mavenCentral()
    }
} // Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    alias(libs.plugins.android.application) version("7.3.1") apply false
    alias(libs.plugins.android.library) version ("7.3.1") apply false
    alias(libs.plugins.kotlin.android) version ("1.7.20") apply false
    alias(libs.plugins.hilt) version ("2.44") apply false
    alias(libs.plugins.spotless)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.detekt)
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    ktlint {
        android.set(true)
        verbose.set(true)
        filter {
            exclude { element -> element.file.path.contains("generated/") }
        }
    }
}

subprojects {

    apply(plugin = "io.gitlab.arturbosch.detekt")
    detekt {
        config = files("${project.rootDir}/detekt.yml")
        parallel = true
    }

    apply(plugin = "com.diffplug.spotless")
    spotless {
        kotlin {
            target("**/*.kt")
            licenseHeaderFile(
                rootProject.file("${project.rootDir}/spotless/copyright.kt"),
                "^(package|object|import|interface)"
            )
        }
    }
}
