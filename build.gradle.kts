// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("com.diffplug.spotless:spotless-plugin-gradle:6.19.0")
    }
}

plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id("com.diffplug.spotless") version "6.19.0" apply false

}

subprojects {
    afterEvaluate {
        project.apply("../spotless.gradle")
    }
}