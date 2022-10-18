buildscript {
    repositories {
        google()
        mavenCentral()
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    alias(libs.plugins.android.application) version("7.3.1") apply false
    alias(libs.plugins.android.library) version ("7.3.1") apply false
    alias(libs.plugins.kotlin.android) version ("1.7.20") apply false
}