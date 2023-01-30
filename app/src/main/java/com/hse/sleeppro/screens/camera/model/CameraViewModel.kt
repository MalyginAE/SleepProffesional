package com.hse.sleeppro.screens.camera.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hse.sleeppro.base.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor() : ViewModel(), EventHandler<CameraEvent> {
    private val _cameraViewState: MutableLiveData<CameraViewState> =
        MutableLiveData(CameraViewState.Display(showCamera = true))
    val cameraViewState: LiveData<CameraViewState> = _cameraViewState


    override fun obtainEvent(event: CameraEvent) {
        when (val currentState = _cameraViewState.value) {
            is CameraViewState.CheckPermission -> reduce(currentState, event)
            is CameraViewState.ClickCamera -> reduce(currentState, event)
            is CameraViewState.Display -> reduce(currentState, event)
        }
    }

    private fun reduce(currentState: CameraViewState.ClickCamera, event: CameraEvent) {

    }

    private fun reduce(currentState: CameraViewState.CheckPermission, event: CameraEvent) {

    }

    private fun reduce(currentState: CameraViewState.Display, event: CameraEvent) {
        when (event) {
            is CameraEvent.TookPhotoEvent -> {
                Log.i("kilo", "Image captured: ${event.uri}")
                _cameraViewState.postValue(currentState.copy(showCamera = false, showPhoto = true, uri = event.uri))
            }
            is CameraEvent.OnImageClick -> {
                _cameraViewState.postValue(currentState.copy(showCamera = true,showPhoto = false))
            }
        }
    }


    // private fun

}