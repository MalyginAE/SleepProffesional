package com.hse.sleeppro.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.PrussianBlue
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrussianBlue)
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Ascona",
                style = TextStyle(),
                color = PanelBlue,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                text = "SleepPro",
                style = TextStyle(),
                color = PanelBlue,
                textAlign = TextAlign.Center
            )
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        delay(1500)
        navController.navigate("main")
    })
}