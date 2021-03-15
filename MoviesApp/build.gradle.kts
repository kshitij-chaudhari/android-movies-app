// TODO //apply(from = "${project.rootDir}/spotless.gradle.kts")

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(com.kc.android.architecture.samples.moviesapp.Libs.androidGradlePlugin)
        classpath(com.kc.android.architecture.samples.moviesapp.Libs.Kotlin.gradlePlugin)
//        classpath Libs.AndroidX.Hilt.gradlePlugin
    }
}
plugins {
    id("com.diffplug.spotless") version "5.11.0"
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        target("**/*.kt")
        targetExclude("$buildDir/**/*.kt")
        targetExclude("bin/**/*.kt")

        ktlint(com.kc.android.architecture.samples.moviesapp.Libs.KtLint.version)
//        licenseHeaderFile(rootProject.file("spotless/copyright.kt"))
    }

    kotlinGradle {
        target("**/*.gradle.kts") // default target for kotlinGradle
        ktlint(com.kc.android.architecture.samples.moviesapp.Libs.KtLint.version) // or ktfmt() or prettier()
    }
}

// tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
// }
