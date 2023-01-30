package com.hse.sleeppro.screens.analyse

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.hse.sleeppro.screens.analyse.model.AnalyseViewModel
import com.hse.sleeppro.screens.analyse.model.AnalyseViewState
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.ui.component.NavigationPanel

@Composable
fun AnalyseDataDisplayView(navController: NavController,analyseViewState: AnalyseViewState.Display){
    NavigationPanel(
        "next",
        onNextButtonClick = { navController.navigate(MainScreen.PostData.route) },
        onPreviousButtonClick = { navController.previousBackStackEntry?.let { navController.navigate(it.id) } },
        "back"
    ) {
        Text(text = analyseViewState.result)
    }
}