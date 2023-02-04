package com.hse.sleeppro.screens.analyse.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hse.sleeppro.base.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnalyseViewModel @Inject constructor() : ViewModel(), EventHandler<AnalyzeEvent> {
    private val BASE_URL = "http://192.168.0.9:8080"
    private val POST_Image = "$BASE_URL/image"
    val client = HttpClient()
    private val _analyseViewState: MutableLiveData<AnalyseViewState> =
        MutableLiveData(AnalyseViewState.Loading)
    val analyseViewState: LiveData<AnalyseViewState> = _analyseViewState


    override fun obtainEvent(event: AnalyzeEvent) {
        when (val currentState = _analyseViewState.value) {
            is AnalyseViewState.Loading -> reduce(currentState, event)
            is AnalyseViewState.Display -> reduce(currentState, event)

        }

    }

    private fun reduce(currentState: AnalyseViewState.Display, event: AnalyzeEvent) {
        when (event) {

        }
    }

    private fun reduce(currentState: AnalyseViewState.Loading, event: AnalyzeEvent) {
        when (event) {
            is AnalyzeEvent.PostRequest -> {
                viewModelScope.launch {
                    val data = client.post<String>(POST_Image)
                    Log.d("RESPONSE", "POST TO $POST_Image returned $data")
                    delay(1000)
                    _analyseViewState.postValue(AnalyseViewState.Display(event.firstName))

                }
            }
        }
    }
}