package com.kc.android.architecture.samples.moviesapp

@Suppress("MemberVisibilityCanBePrivate", "unused")
object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha09"

    object Kotlin {
        const val version = "1.4.30"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
    }

    object KotlinX {
        const val version = "1.4.2"
        const val CoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val CoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Android {
        const val version = "1.3.0"
        const val material = "com.google.android.material:material:1.3.0"
    }

    object AndroidX {
        object Core {
            const val version = "1.3.2"
            const val coreKtx = "androidx.core:core-ktx:$version"
        }

        object AppCompat {
            const val version = "1.2.0"
            const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        }

        object Hilt {
            const val version = "2.33-beta"
            const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
            const val compiler = "com.google.dagger:hilt-compiler:$version"
            const val android = "com.google.dagger:hilt-android:$version"
        }

        object Compose {
            const val version = "1.0.0-beta01"
            const val lifecycleComposeVersion = "1.0.0-alpha03"

            const val ui = "androidx.compose.ui:ui:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsCore = "androidx.compose.material:material-icons-core:$version"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:$version"
            const val lifecycleViewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleComposeVersion"
            const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:$version"
            const val runtimeRxJava2 = "androidx.compose.runtime:runtime-rxjava2:$version"
            const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:$version"
        }

        object Test {
            object Ext {
                const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit:version"
            }

            object Espresso {
                const val version = "3.3.0"
                const val core = "androidx.test.espresso:espresso-core:$version"
            }
        }

        object Lifecycle {
            const val version = "2.3.0"
            const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Activity {
            const val version = "1.3.0-alpha03"
            const val compose = "androidx.activity:activity-compose:$version"
        }
    }

    object Junit {
        const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }
}

