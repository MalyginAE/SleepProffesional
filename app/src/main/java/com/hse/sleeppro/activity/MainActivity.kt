package com.hse.sleeppro.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.screens.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(
        ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class,
        ExperimentalMaterialApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "main") {
                composable("splash") {
                    SplashScreen(navController = navController)
                }

                composable("main") {
//                    val settings = SettingsBundle(
//                        isDarkMode = isDarkMode.value,
//                        style = currentStyle.value,
//                        textSize = currentFontSize.value,
//                        cornerStyle = currentCornersStyle.value,
//                        paddingSize = currentPaddingSize.value
//                    )

                    MainScreen(navController = navController,

                    )
                }

            }
        }
    }

}

