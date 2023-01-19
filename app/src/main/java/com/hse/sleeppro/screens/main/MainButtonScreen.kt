package com.hse.sleeppro.screens.main

import androidx.annotation.StringRes
import com.hse.sleeppro.R

sealed class MainScreen(val route: String, @StringRes val resourceId: Int) {
    object Greeting : MainScreen("greeting", R.string.title_next)
    object Cards : MainScreen("formChoose", R.string.title_next)
    object Camera : MainScreen("camera", R.string.title_next)
   // object Settings : MainBottomScreen("settingsFlow", R.string.title_settings)
}
