package com.hse.sleeppro.screens.analyse.model

import android.content.Context
import android.net.Uri
import com.hse.sleeppro.screens.forms.FormViewState

sealed class AnalyzeEvent {
    data class PostRequest(
        val uri: Uri?,
        val fvs: FormViewState.Display,
        val context: Context

    ) : AnalyzeEvent()

}
