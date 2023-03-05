package com.hse.sleeppro.ui.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hse.sleeppro.ui.component.button.BackButton
import com.hse.sleeppro.ui.component.button.NextButton
import com.hse.sleeppro.ui.component.button.ReloadButton
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.cardsFont

@Composable
fun NavigationButton(
    nextButtonText: String,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit,
    onReloadButtonClick: () -> Unit,
    previousButtonText: String,
    reloadButtonText: String
) {
    //ReloadButton(reloadButtonText, onReloadButtonClick)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, bottom = 15.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        ReloadButton(reloadButtonText, onReloadButtonClick)
//        Box(modifier = Modifier, contentAlignment = Alignment.End) {
            BackButton(previousButtonText, onPreviousButtonClick)
            NextButton(nextButtonText, onNextButtonClick)
       // }

    }
}


@Preview(showBackground = true)
@Composable
fun RestartButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .width(40.dp)
    ) {
        Box(
            modifier = Modifier
                .widthIn(min = 120.dp)
                .fillMaxWidth(0.15f)
                .height(40.dp)

                .background(Color.LightGray)
                .align(Alignment.TopEnd)
                .clickable { Log.d("button clicked", "button restart was clicked") }

        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "",
                    Modifier
                        .padding(end = 5.dp)
                        .offset(y = 6.dp)
                )
                Text(text = "Restart", fontFamily = cardsFont, fontSize = 22.sp)
            }
        }
    }
}
