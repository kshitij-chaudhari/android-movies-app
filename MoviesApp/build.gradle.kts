
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

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}