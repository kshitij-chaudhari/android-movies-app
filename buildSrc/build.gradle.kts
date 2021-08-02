plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

/**
 * [com.kc.android.architecture.samples.moviesapp.Libs] cannot be accessed in
 * buildSrc/build.gradle. So defining Plugins specific constants here.
 *
 * Some of the version_numbers like hilt needs to be managed
 * here as well as in [com.kc.android.architecture.samples.moviesapp.Libs]
 */
object Plugins {
    object Versions {
        const val android = "7.1.0-alpha06"
        const val kotlin = "1.5.10"
        const val spotless = "5.11.1"
        const val hilt = "2.37"
    }
    const val android = "com.android.tools.build:gradle:${Versions.android}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val spotless = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}

/**
 * Mainly custom plugins specific dependencies are only needed here to compile them.
 * App specific plugins like android-gradle-plugin and kotlin-gradle-plugin can still go
 * inside the app-level build.gradle.
 *
 * All plugins are kept here to manage plugins just at this one place.
 */
dependencies {
    implementation(Plugins.android)
    implementation(Plugins.kotlin)
    implementation(Plugins.spotless)
    implementation(Plugins.hilt)
}