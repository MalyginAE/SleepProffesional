package com.hse.sleeppro.screens.analyse.model

sealed class AnalyzeEvent {
    data class PostRequest(
        val uri: String,
        val firstName: String

                           ) : AnalyzeEvent()

}
