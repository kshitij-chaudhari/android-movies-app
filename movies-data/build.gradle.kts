import com.kc.android.architecture.samples.moviesapp.App
import com.kc.android.architecture.samples.moviesapp.Libs

plugins {
    id("com.android.library")
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
    api(Libs.AndroidX.Core.coreKtx)
    api(Libs.AndroidX.AppCompat.appcompat)

    // room
    api(Libs.AndroidX.Room.roomRuntime)
    kapt(Libs.AndroidX.Room.roomCompiler)
    api(Libs.AndroidX.Room.roomKtx)

    // paging
    api(Libs.AndroidX.Paging.pagingRuntime)

    // coroutines
    api(Libs.KotlinX.CoroutinesCore)
    api(Libs.KotlinX.CoroutinesAndroid)

    // test
    testApi(Libs.Junit.junit)

    // hilt
    api(Libs.Dagger.Hilt.android)
    kapt(Libs.Dagger.Hilt.compiler)

    // ok-http
    api(Libs.OkHttp3.loggingInterceptor)

    // retrofit
    api(Libs.Retrofit2.retrofit)
    api(Libs.Retrofit2.gsonConverter)
}
