package com.hse.sleeppro.screens.camera.model

import android.net.Uri
import androidx.compose.runtime.MutableState
import java.io.File
import java.util.concurrent.ExecutorService

data class CameraSettings(
    val requestCameraPermission: () -> Unit,
    val getOutPutDirectory: () -> File,
    val handleImageCapture: (Uri) -> Unit,
    var shouldShowPhoto: MutableState<Boolean>,
    var shouldShowCamera: MutableState<Boolean>,
    var photoUri: Uri,
    val cameraExecutor: ExecutorService,
    val outputDir: File

)