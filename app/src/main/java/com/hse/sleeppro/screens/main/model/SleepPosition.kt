package com.hse.sleeppro.screens.main.model

import androidx.compose.ui.graphics.Color

data class SleepPosition(val text: String,
                         var position: Position,
                         val onClick: () -> Unit,
                         val onChoseBackgroundColor: () -> Color
)

enum class Position(){
    Back, Side, Front, Nothing
}