package com.hse.sleeppro.screens.camera.model

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hse.sleeppro.base.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor() : ViewModel(), EventHandler<CameraEvent> {
    private val _cameraViewState: MutableLiveData<CameraViewState> = MutableLiveData(CameraViewState.RequestPermission)
    val cameraViewState: LiveData<CameraViewState> = _cameraViewState


    override fun obtainEvent(event: CameraEvent) {
        when (val currentState = _cameraViewState.value) {
            is CameraViewState.RequestPermission -> reduce(currentState, event)
        }
//        when(val ){}
    }

    private fun reduce(currentState: CameraViewState.RequestPermission, event: CameraEvent) {

    }




}