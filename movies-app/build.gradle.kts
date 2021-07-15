import com.kc.android.architecture.samples.moviesapp.App
import com.kc.android.architecture.samples.moviesapp.Libs

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = App.compileSdk
    buildToolsVersion = Libs.buildToolsVersion

    defaultConfig {
        minSdk = App.minSdkVersion
        targetSdk = App.targetSdkVersion
        versionCode = App.versionCode
        versionName = App.versionName
        applicationId = App.applicationId

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // TODO remove hard coded key and accept from project properties
        buildConfigField("String", "TMDB_API_KEY", "\"${project.property("TMDB_API_KEY")}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }
}

dependencies {
    // android
    implementation(Libs.Android.material)

    // androidx
    implementation(Libs.AndroidX.Core.coreKtx)
    implementation(Libs.AndroidX.AppCompat.appcompat)
    implementation(Libs.AndroidX.Lifecycle.runtimeKtx)
    implementation(Libs.AndroidX.Activity.compose)

    // compose
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.uiTooling)
    implementation(Libs.AndroidX.Compose.foundation)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.materialIconsCore)
    implementation(Libs.AndroidX.Compose.materialIconsExtended)
    implementation(Libs.AndroidX.Compose.lifecycleViewModelCompose)
    implementation(Libs.AndroidX.Compose.runtimeLiveData)
    implementation(Libs.AndroidX.Compose.runtimeRxJava2)
    implementation(Libs.AndroidX.Paging.pagingCompose)

    // hilt
    implementation(Libs.Dagger.Hilt.android)
    kapt(Libs.Dagger.Hilt.compiler)

    // Accompanist
    implementation(Libs.Accompanist.accompanist)
    implementation(Libs.Coil.coil)

    // test
    testImplementation(Libs.Junit.junit)

    // android-test
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.Espresso.core)
    androidTestImplementation(Libs.AndroidX.Compose.uiTestJunit4)

    // modules
    implementation(project(":movies-data"))
}
