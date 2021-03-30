import com.kc.android.architecture.samples.moviesapp.App
import com.kc.android.architecture.samples.moviesapp.Libs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(App.compileSdk)
    buildToolsVersion(Libs.buildToolsVersion)

    defaultConfig {
        minSdkVersion(App.minSdkVersion)
        targetSdkVersion(App.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    // androidx
    implementation(Libs.AndroidX.Core.coreKtx)
    implementation(Libs.AndroidX.AppCompat.appcompat)

    // coroutines
    implementation(Libs.KotlinX.CoroutinesCore)
    implementation(Libs.KotlinX.CoroutinesAndroid)

    // test
    testImplementation(Libs.Junit.junit)

    // hilt
    implementation(Libs.Dagger.Hilt.android)
    kapt(Libs.Dagger.Hilt.compiler)

    // ok-http
    implementation(Libs.OkHttp3.loggingInterceptor)

    // retrofit
    implementation(Libs.Retrofit2.retrofit)
    implementation(Libs.Retrofit2.gsonConverter)

    // modules
    implementation(project(":movies-model"))
}
