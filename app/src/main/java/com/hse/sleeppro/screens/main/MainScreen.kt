package com.hse.sleeppro.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hse.sleeppro.screens.camera.CameraScreen
import com.hse.sleeppro.screens.camera.model.CameraViewModel
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
    Column {
        Box(modifier = Modifier.weight(1f)) {
            NavHost(
                navController = navChildController,
                startDestination = MainScreen.Greeting.route
            ) {
                //greetingFlow(navController)
                composable(MainScreen.Greeting.route) {
                    GreetingScreen(navChildController)
                }

                composable(MainScreen.Cards.route) {
                    val formViewModel = hiltViewModel<FormViewModel>()
                    FormScreen(
                        navChildController, formViewModel = formViewModel
                    )
                }

                composable(MainScreen.Camera.route) {

                    val cameraViewModel = hiltViewModel<CameraViewModel>()
                    CameraScreen(
                        navController = navChildController,
//                        cameraSettings = cameraSettings,
                        cameraViewModel = cameraViewModel,


                        // navChildController, formViewModel = formViewModel
                    )
                }

                composable(MainScreen.PostData.route) {

                    Text(text = "YRRRRAAA")
                }

            }
        }
    }
}



