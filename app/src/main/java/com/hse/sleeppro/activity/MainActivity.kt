package com.hse.sleeppro.activity

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hse.sleeppro.R
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.screens.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    private  var outputDirectory: File
  //  private  var cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()

    private var shouldShowCamera: MutableState<Boolean> = mutableStateOf(false)

    private lateinit var photoUri: Uri
    private var shouldShowPhoto: MutableState<Boolean> = mutableStateOf(false)
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.i("kilo", "Permission granted")
            shouldShowCamera.value = true
        } else {
            Log.i("kilo", "Permission denied")
        }
    }

    @OptIn(
        ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class,
        ExperimentalMaterialApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            if (shouldShowCamera.value) {
//                CameraView(
//                    outputDirectory = outputDirectory,
//                    executor = cameraExecutor,
//                    onImageCaptured = ::handleImageCapture,
//                    onError = { Log.e("kilo", "View error:", it) }
//                )
//            }
//
//            if (shouldShowPhoto.value) {
//                Image(
//                    painter = rememberImagePainter(photoUri),
//                    contentDescription = null,
//                    modifier = Modifier.fillMaxSize()
//                )
//            }

             requestCameraPermission()

//            outputDirectory =
//            cameraExecutor = Executors.newSingleThreadExecutor()

            val navController = rememberNavController()
            // private val  requestPermissionLauncher: registerForActivityResult()


            NavHost(navController = navController, startDestination = "splash") {
                composable("splash") {
                    SplashScreen(navController = navController)
                }

                composable("main") {
//                    val settings = SettingsBundle(
//                        isDarkMode = isDarkMode.value,
//                        style = currentStyle.value,
//                        textSize = currentFontSize.value,
//                        cornerStyle = currentCornersStyle.value,
//                        paddingSize = currentPaddingSize.value
//                    )

                    MainScreen(
                        navController = navController,
                        requestCameraPermission = ::requestCameraPermission,
//                        cameraSettings = CameraSettings(
//                            requestCameraPermission = ::requestCameraPermission,
//                            getOutPutDirectory = ::getOutputDirectory,
//                            handleImageCapture = ::handleImageCapture,
//                            shouldShowCamera = shouldShowCamera,
//                            shouldShowPhoto = shouldShowPhoto,
//                            photoUri = photoUri,
//                            cameraExecutor = Executors.newSingleThreadExecutor(),//убрать в будушем
//                            outputDir = getOutputDirectory()
//                            )


                    )
                }

            }
        }
    }

    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
    }


    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i("kilo", "Permission previously granted")
               // shouldShowCamera.value = true
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            ) -> Log.i("kilo", "Show camera permissions dialog")

            else -> requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun handleImageCapture(uri: Uri) {
        Log.i("kilo", "Image captured: $uri")
       // shouldShowCamera.value = false

        photoUri = uri
        //shouldShowPhoto.value = true
    }



}

