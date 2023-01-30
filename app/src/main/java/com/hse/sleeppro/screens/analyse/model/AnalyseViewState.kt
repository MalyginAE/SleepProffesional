package com.hse.sleeppro.screens.analyse.model

sealed class AnalyseViewState {
    object Loading : AnalyseViewState()
    data class Display(val result:String):AnalyseViewState()
}