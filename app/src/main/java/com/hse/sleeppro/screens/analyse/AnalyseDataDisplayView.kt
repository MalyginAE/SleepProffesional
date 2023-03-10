package com.hse.sleeppro.screens.analyse

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.hse.sleeppro.screens.analyse.model.AnalyseViewState
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.ui.component.NavigationPanel

@Composable
fun AnalyseDataDisplayView(navController: NavController,analyseViewState: AnalyseViewState.Display){
    NavigationPanel(
        "next",
        onNextButtonClick = { navController.navigate(MainScreen.PostData.route) },
        onPreviousButtonClick = { navController.navigate(MainScreen.Camera.route)},
        "back"
    ) {

        Text(text = analyseViewState.result)
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clickable {

                },
            painter = rememberImagePainter(analyseViewState.receivedImage),
            contentDescription = null,

            )
    }
}