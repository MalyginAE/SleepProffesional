package com.hse.sleeppro.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.PrussianBlue
import com.hse.sleeppro.ui.theme.cardsFont


@Composable
fun LeftInfoPanel() {
    val fontSize = 10
    Row() {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.12f)
                .background(PrussianBlue)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green)
                    .align(Alignment.Center)
            ) {
                for (action in mapOf("Personalise" to Color.White,"Scan" to PrussianBlue,
                    "Analysis" to PrussianBlue,"Results" to PrussianBlue))
                Box(
                    modifier = Modifier
                        .background(if (action.value == Color.White) PanelBlue else Color.LightGray )
                        .fillMaxWidth()
                ) {
                    Text(
                        text = action.key,
                        color = action.value,
                        fontFamily = cardsFont,
                        fontSize = fontSize.sp,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }

        }

    }
}