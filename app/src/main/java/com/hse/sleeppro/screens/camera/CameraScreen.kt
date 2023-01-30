package com.hse.sleeppro.screens.camera

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.hse.sleeppro.R
import com.hse.sleeppro.screens.camera.model.CameraEvent
import com.hse.sleeppro.screens.camera.model.CameraViewModel
import com.hse.sleeppro.screens.camera.model.CameraViewState
import java.io.File

@Composable
fun CameraScreen(cameraViewModel: CameraViewModel, navController: NavController) {

    val context = LocalContext.current
    val activity = context as ComponentActivity
    val viewState = cameraViewModel.cameraViewState.observeAsState()

    fun getOutputDirectory(): File {
        val mediaDir = activity.externalMediaDirs.firstOrNull()?.let {
            File(it, activity.resources.getString(R.string.app_name)).apply { mkdirs() }
        }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else activity.filesDir
    }

//    fun handleImageCapture(uri: Uri) {
//        Log.i("kilo", "Image captured: $uri")
//        // shouldShowCamera.value = false
//
//        // photoUri = uri
//        //shouldShowPhoto.value = true
//    }
    when (val state = viewState.value) {
        is CameraViewState.Display -> {
            CameraDisplayView(
                viewState = state,
                navController = navController,
                getOutputDirectory = ::getOutputDirectory,
                onImageCapture = { cameraViewModel.obtainEvent(CameraEvent.TookPhotoEvent(it)) }
            )

        }

    }
}
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

//// requestCameraPermission()
//TextButton(onClick = { navController.navigate(MainScreen.PostData.route) }) {
//    Text(text = "Hello")
//}


