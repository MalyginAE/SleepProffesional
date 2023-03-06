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
import com.hse.sleeppro.ui.component.cards.AnalysisInfo
import com.hse.sleeppro.ui.component.cards.CardState
import com.hse.sleeppro.ui.component.cards.PersonaliseCard
import com.hse.sleeppro.ui.component.cards.ResultInfo
import com.hse.sleeppro.ui.component.cards.ScanInfo

@Composable
fun AnalyseDataDisplayView(navController: NavController,analyseViewState: AnalyseViewState.Display){
    NavigationPanel(
        "Next",
        onNextButtonClick = { navController.navigate(MainScreen.PostData.route) },
        onPreviousButtonClick = { navController.navigate(MainScreen.Camera.route)},
        "Back",
        reloadButtonText = "Reload",
        onReloadButtonClick = {},
        panelCards = {
            PersonaliseCard(cardState = CardState.PASSIVE)
            AnalysisInfo(state = CardState.ACTIVE)
            ScanInfo()
            ResultInfo()
        }
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