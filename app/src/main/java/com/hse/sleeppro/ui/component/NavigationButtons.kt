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
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.cardsFont

@Composable
fun NavigationButton(nextButtonText:String,
                     onNextButtonClick: () -> Unit,
                    onPreviousButtonClick: () -> Unit,
                    previousButtonText: String
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, bottom = 15.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        BackButton(previousButtonText,onPreviousButtonClick)
        NextButton(nextButtonText,onNextButtonClick)
    }
}


@Composable
fun NextButton(textButton:String , onNextButtonClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .widthIn(min = 100.dp)
                .fillMaxWidth(0.2f)
                .height(40.dp)
                .background(PanelBlue)
                .align(Alignment.BottomEnd)
                .clickable { onNextButtonClick.invoke() }
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = textButton, fontFamily = cardsFont, fontSize = 22.sp)
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    Modifier
                        .padding(start = 5.dp)
                        .offset(y = 6.dp)
                )
            }
        }
    }
}


@Composable
fun BackButton(backTextButton: String, onPreviousButtonClick: ()->Unit) {
    Box() {
        Box(
            modifier = Modifier
                .widthIn(min = 100.dp)
                .fillMaxWidth(0.15f)
                .height(40.dp)
                .background(Color.LightGray)
                .align(Alignment.BottomStart)
                .clickable { Log.d("back button clicked", "back button back was clicked")
                onPreviousButtonClick.invoke()}
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "",
                    Modifier.offset(y = 6.dp)
                )
                Text(text = backTextButton, fontSize = 22.sp, fontFamily = cardsFont)
            }
        }
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
