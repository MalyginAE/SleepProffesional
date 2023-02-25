package com.hse.sleeppro.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hse.sleeppro.screens.analyse.AnalyzeScreen
import com.hse.sleeppro.screens.analyse.model.AnalyseViewModel
import com.hse.sleeppro.screens.camera.CameraScreen
import com.hse.sleeppro.screens.camera.model.CameraViewModel
import com.hse.sleeppro.screens.forms.FormScreen
import com.hse.sleeppro.screens.forms.model.FormViewModel
import com.hse.sleeppro.screens.greetting.GreetingScreen


@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun MainScreen(
    navController: NavController,
    requestCameraPermission: () -> Unit,
    //  cameraSettings: CameraSettings
) {
    val navChildController = rememberNavController()
    val cameraViewModel = hiltViewModel<CameraViewModel>()
    val formViewModel = hiltViewModel<FormViewModel>()
    Column {
        Box(modifier = Modifier.weight(1f)) {
            NavHost(
                navController = navChildController,
                startDestination = MainScreen.Greeting.route
            ) {
                composable(MainScreen.Greeting.route) {
                    GreetingScreen(navChildController)
                }

                composable(MainScreen.Cards.route) {
                    FormScreen(
                        navChildController, formViewModel = formViewModel
                    )
                }

                composable(MainScreen.Camera.route) {
                    CameraScreen(
                        navController = navChildController,
                        cameraViewModel = cameraViewModel,
                    )
                }

                composable(MainScreen.PostData.route) {
                    val analyseViewModel = hiltViewModel<AnalyseViewModel>()
                    AnalyzeScreen(
                        navController = navChildController,
                        cameraViewModel = cameraViewModel,
                        formViewModel = formViewModel,
                        analyseViewModel = analyseViewModel
                    )
                }

            }
        }
    }
}



