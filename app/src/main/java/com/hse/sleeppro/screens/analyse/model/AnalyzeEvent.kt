package com.hse.sleeppro.screens.analyse.model

import android.content.Context
import android.net.Uri

sealed class AnalyzeEvent {
    data class PostRequest(
        val uri: Uri?,
        val firstName: String,
        val context: Context

    ) : AnalyzeEvent()

}
