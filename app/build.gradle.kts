plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.6.0"
    kotlin("android")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
}

android {
    namespace = Config.packageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }

//    javaCompileOptions {
//        annotationProcessorOptions {
//            arguments += [
//                "room.schemaLocation":"$projectDir/schemas".toString(),
//                "room.incremental":"true",
//                "room.expandProjection":"true"
//            ]
//        }
//    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Compose.materialIcons)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.coil_compose)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.livedata)
    implementation(Dependencies.Compose.accompanist)

    implementation(Dependencies.Lifecycle.lifecycleKtx)
    implementation(Dependencies.Lifecycle.viewModelCompose)
    implementation(Dependencies.Lifecycle.activityCompose)
    implementation(Dependencies.Navigation.navigationCompose)

    implementation(Dependencies.Kotlin.serialization)

    //Camera
    implementation(Dependencies.Camera.camera)
    implementation(Dependencies.Camera.cameraView)
    implementation(Dependencies.Camera.cameraLifecycle)
    implementation(Dependencies.Camera.compressPhoto)

    // Hilt
    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.navigation)
    kapt(Dependencies.Hilt.compiler)

    // Room
    implementation(Dependencies.Room.ktx)
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.paging)
    kapt(Dependencies.Room.compiler)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidJUnit)
    androidTestImplementation(Dependencies.Test.espresso)

    androidTestImplementation(Dependencies.Compose.uiTest)
    debugImplementation(Dependencies.Compose.toolingTest)

    //HttpClient
    implementation(Dependencies.HttpClient.ktor_core)
    implementation(Dependencies.HttpClient.ktorSerialization)
    implementation(Dependencies.HttpClient.androidClient)
    implementation(Dependencies.HttpClient.ktorLogging)
    implementation(Dependencies.HttpClient.ktorClientGson)
    implementation(Dependencies.HttpClient.ktorClientGsonJvm)
}