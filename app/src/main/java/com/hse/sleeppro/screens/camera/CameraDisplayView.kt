package com.hse.sleeppro.screens.camera

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.hse.sleeppro.screens.camera.model.CameraViewState
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.ui.component.NavigationPanel
import com.hse.sleeppro.ui.component.cards.AnalysisInfo
import com.hse.sleeppro.ui.component.cards.CardState
import com.hse.sleeppro.ui.component.cards.PersonaliseCard
import com.hse.sleeppro.ui.component.cards.ResultInfo
import com.hse.sleeppro.ui.component.cards.ScanInfo
import java.io.File
import java.util.concurrent.Executors

@Composable
fun CameraDisplayView(
    navController: NavController,
    viewState: CameraViewState.Display,
    modifier: Modifier = Modifier,
    getOutputDirectory: () -> File,
    onImageCapture: (Uri) -> Unit,
    onImageClick: () -> Unit
) {
    NavigationPanel(
        "Next",
        onNextButtonClick = { navController.navigate(MainScreen.PostData.route) },
        onPreviousButtonClick = {
            navController.navigate(MainScreen.PersonCount.route)
        } ,
        "Back",
        {},
        panelCards = {
            PersonaliseCard(cardState = CardState.PASSIVE)
            AnalysisInfo(state = CardState.ACTIVE)
            ScanInfo()
            ResultInfo()
        },
       reloadButtonText =  "Reload"
    ) {
        if (viewState.showCamera) {
            Box(modifier = Modifier.fillMaxSize()) {
                CameraView(
                    outputDirectory = getOutputDirectory(),
                    executor = Executors.newSingleThreadExecutor(),
                    onImageCaptured = onImageCapture,
                    onError = { Log.e("kilo", "View error:", it) })
            }
        }
        if (viewState.showPhoto && viewState.uri != null) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onImageClick()
                    },
                painter = rememberImagePainter(viewState.uri),
                contentDescription = null,

                )
        }
    }

}