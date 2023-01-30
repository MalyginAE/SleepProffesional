package com.hse.sleeppro.screens.analyse.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hse.sleeppro.base.EventHandler
import com.hse.sleeppro.screens.camera.model.CameraEvent
import com.hse.sleeppro.screens.camera.model.CameraViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnalyseViewModel @Inject constructor() : ViewModel(), EventHandler<AnalyzeEvent> {
    private val _analyseViewState: MutableLiveData<AnalyseViewState> =
        MutableLiveData(AnalyseViewState.Loading)
    val analyseViewState: LiveData<AnalyseViewState> = _analyseViewState


    override fun obtainEvent(event: AnalyzeEvent) {
        when (val currentState = _analyseViewState.value) {
            is AnalyseViewState.Loading -> reduce(currentState, event)
        }

    }

    private fun reduce(currentState: AnalyseViewState.Loading, event: AnalyzeEvent) {
        when (event) {
            is AnalyzeEvent.PostRequest -> {
                viewModelScope.launch {
                    delay(1000)
                    _analyseViewState.postValue(AnalyseViewState.Display(event.firstName))
                }
            }
        }
    }
}