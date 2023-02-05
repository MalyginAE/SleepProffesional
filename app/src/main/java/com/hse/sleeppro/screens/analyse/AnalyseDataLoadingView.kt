package com.hse.sleeppro.screens.analyse

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.ui.component.NavigationPanel

@Composable
fun AnalyseDataLoadingView(navController: NavController) {
    NavigationPanel(
        "next",
        onNextButtonClick = { navController.navigate(MainScreen.PostData.route) },
        onPreviousButtonClick = { navController.previousBackStackEntry?.let { navController.navigate(it.id) } },
        "back"
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Blue
            )
        }
    }
}