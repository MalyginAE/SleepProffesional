package com.hse.sleeppro.screens.analyse

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.hse.sleeppro.screens.analyse.model.AnalyseViewModel
import com.hse.sleeppro.screens.analyse.model.AnalyseViewState
import com.hse.sleeppro.screens.analyse.model.AnalyzeEvent
import com.hse.sleeppro.screens.camera.model.CameraViewModel
import com.hse.sleeppro.screens.forms.FormViewState
import com.hse.sleeppro.screens.forms.model.FormViewModel

@Composable
fun AnalyzeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    cameraViewModel: CameraViewModel,
    formViewModel: FormViewModel,
    analyseViewModel: AnalyseViewModel
) {
    val viewState = analyseViewModel.analyseViewState.observeAsState()

    when (val state = viewState.value) {
        is AnalyseViewState.Loading -> {
           AnalyseDataLoadingView(navController = navController)
        }
        is AnalyseViewState.Display -> {
            AnalyseDataDisplayView(navController = navController, state)
        }
    }
    LaunchedEffect(key1 = viewState, block = {
        val fvs: FormViewState.Display = formViewModel.formViewState.value as FormViewState.Display
        analyseViewModel.obtainEvent(
            AnalyzeEvent.PostRequest("", fvs.enterNameModel.text)
        )
    })

}