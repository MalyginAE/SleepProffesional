package com.hse.sleeppro.screens.camera.model

import android.net.Uri

sealed class CameraViewState {
    object Loading : CameraViewState()
    object CheckPermission : CameraViewState()
    data class Display(
        var showCamera:Boolean =false,
        var showPhoto:Boolean = false,
        var uri: Uri? = null


    ):CameraViewState()
    object ClickCamera : CameraViewState()
}
