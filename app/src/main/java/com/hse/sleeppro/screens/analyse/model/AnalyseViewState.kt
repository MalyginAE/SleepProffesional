package com.hse.sleeppro.screens.analyse.model

import java.io.File

sealed class AnalyseViewState {
    object Loading : AnalyseViewState()
    data class Display(val result:String,val receivedImage:File):AnalyseViewState()
}