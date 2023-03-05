package com.hse.sleeppro.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.PrussianBlue

@Composable
fun NavigationPanel(
    nextButtonText: String,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit,
    previousButtonText: String,
    onReloadButtonClick: () -> Unit,
    reloadButtonText: String,
    cards: @Composable () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row {
            LeftInfoPanel()
            ContentWithNavigationButton(
                cards,
                nextButtonText,
                onNextButtonClick,
                onPreviousButtonClick,
                previousButtonText,
                onReloadButtonClick,
                reloadButtonText
            )
        }
    }
}

@Composable
fun ContentWithNavigationButton(
    cards: @Composable () -> Unit,
    nextButtonText: String,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit,
    previousButtonText: String,
    onReloadButtonClick: () -> Unit,
    reloadButtonText: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 44.dp, start = 44.dp)
    ) {
        Column {
//            RestartButton()
            Box(
                modifier = Modifier
                    .padding(top = 15.dp)
//                    .fillMaxHeight(0.8f)
            ) {
                cards()
            }
            NavigationButton(
                nextButtonText,
                onNextButtonClick,
                onPreviousButtonClick,
                onReloadButtonClick,
                previousButtonText,
                reloadButtonText
            )
        }
    }
}










