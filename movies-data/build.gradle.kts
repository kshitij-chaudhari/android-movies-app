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

        // Enable using experimental APIs
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }

    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    // modules
    implementation(project(":movies-domain"))

    // androidx
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)

    // room
    implementation(Libs.AndroidX.Room.roomRuntime)
    kapt(Libs.AndroidX.Room.roomCompiler)
    implementation(Libs.AndroidX.Room.roomKtx)

    // paging
    implementation(Libs.AndroidX.Paging.pagingRuntime)

    // coroutines
    implementation(Libs.Kotlin.Coroutines.core)
    implementation(Libs.Kotlin.Coroutines.android)

    // hilt
    implementation(Libs.Google.Hilt.android)
    kapt(Libs.Google.Hilt.compiler)

    // ok-http & retrofit
    implementation(Libs.Retrofit2.retrofit)
    api(Libs.Retrofit2.gsonConverter)
    api(Libs.OkHttp3.loggingInterceptor)

    // test
    testImplementation(Libs.Test.testCoreKtx)
    testImplementation(Libs.Test.archCoreTesting)
    testImplementation(Libs.Test.junit)
    testImplementation(Libs.Test.androidxJunitKtx)
    testImplementation(Libs.Test.mockk)
    testImplementation(Libs.Test.truth)
    testImplementation(Libs.Test.robolectric)

    testImplementation(Libs.AndroidX.Room.testing)
    testImplementation(Libs.Kotlin.Coroutines.test)
    testImplementation(Libs.Google.Hilt.androidTesting)
    testImplementation(Libs.OkHttp3.mockWebServer)

    kaptTest(Libs.AndroidX.Room.roomCompiler)
}
