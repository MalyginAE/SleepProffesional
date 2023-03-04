package com.hse.sleeppro.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hse.sleeppro.R
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.ui.component.cards.PersonaliseCard
import com.hse.sleeppro.ui.theme.Green500
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
                .width(278.dp)
                .background(Green500),

        ) {
            Box(Modifier.fillMaxWidth().padding(top = 38.dp), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.ascona_logo),
                    contentDescription = "Logo company ",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .background(color = Green500)
                        .width(190.dp)
                        .height(50.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
//                    .background(Green500)
                    .align(Alignment.Center)

            ) {
                PersonaliseCard()
//                for (action in mapOf("Personalise" to Color.White,"Scan" to PrussianBlue,
//                    "Analysis" to PrussianBlue,"Results" to PrussianBlue))
//                Box(
//                    modifier = Modifier
//                        .background(if (action.value == Color.White) PanelBlue else Color.LightGray)
//                        .fillMaxWidth()
//                ) {
//                    Text(
//                        text = action.key,
//                        color = action.value,
//                        fontFamily = cardsFont,
//                        fontSize = fontSize.sp,
//                        modifier = Modifier.padding(5.dp)
//                    )
//                }
            }

        }

    }
}