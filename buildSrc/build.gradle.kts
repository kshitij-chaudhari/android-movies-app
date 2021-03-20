plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.0-alpha10")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:5.11.0")
}