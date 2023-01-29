package com.hse.sleeppro.screens.camera.model

sealed class CameraViewState {
object Loading:CameraViewState()
    object RequestPermission:CameraViewState()
}
