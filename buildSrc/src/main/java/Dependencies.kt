
object Dependencies {

    object Camera{
        const val camerax_version = "1.0.1"

        const val  camera = "androidx.camera:camera-camera2:$camerax_version"
        const val cameraLifecycle = "androidx.camera:camera-lifecycle:$camerax_version"
        const val cameraView = "androidx.camera:camera-view:1.0.0-alpha27"
        const val compressPhoto = "id.zelory:compressor:3.0.1"
    }

    object Compose {
        const val version = "1.0.5"
        const val ui = "androidx.compose.ui:ui:$version"
        const val material = "androidx.compose.material:material:$version"
        const val materialIcons = "androidx.compose.material:material-icons-extended:$version"
        const val tooling = "androidx.compose.ui:ui-tooling-preview:$version"
        const val livedata = "androidx.compose.runtime:runtime-livedata:$version"
        const val toolingTest = "androidx.compose.ui:ui-tooling:$version"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
        const val accompanist = "com.google.accompanist:accompanist-systemuicontroller:0.18.0"
        const val coil_compose = "io.coil-kt:coil-compose:1.4.0"
    }

    object Kotlin {
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2"
    }

    object Hilt {
        const val version = "2.40.5"
        const val android = "com.google.dagger:hilt-android:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0-rc01"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Room {
        private const val version = "2.3.0"
        const val ktx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val paging = "androidx.room:room-paging:2.4.0-alpha04"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Navigation {
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-alpha10"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"
    }

    object Lifecycle {
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
    }

    object Test {
        const val jUnit = "junit:junit:4.+"
        const val androidJUnit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object HttpClient{
        private const val ktor_version = "1.6.1"
        const val ktor_core = "io.ktor:ktor-client-core:$ktor_version"
       const val androidClient = "io.ktor:ktor-client-android:$ktor_version"
        const val ktorSerialization = "io.ktor:ktor-client-serialization:$ktor_version"
        const val ktorLogging = "io.ktor:ktor-client-logging:$ktor_version"
        const val ktorClientGsonJvm = "io.ktor:ktor-client-json-jvm:$ktor_version"
        const val ktorClientGson = "io.ktor:ktor-client-gson:$ktor_version"
    }


}