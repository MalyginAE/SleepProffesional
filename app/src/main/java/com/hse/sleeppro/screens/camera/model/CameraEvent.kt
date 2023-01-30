package com.hse.sleeppro.screens.camera.model

import android.net.Uri

sealed class CameraEvent {
    data class TookPhotoEvent(val uri:Uri):CameraEvent()
}
