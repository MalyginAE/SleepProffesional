package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.PanelGray
import com.hse.sleeppro.ui.theme.PrussianBlue
import com.hse.sleeppro.ui.util.countEqualDistance

@Composable
fun EnterOnePossibleChoise(modifier: Modifier = Modifier, cardTitle: String, genderList: Map<String, Boolean>, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .background(PanelGray)
    ) {
        Column() {
            CardTitle(title = cardTitle)

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
            ) {
                GenderCard(genderList, onClick)
            }
        }
    }
}

@Composable
private fun GenderCard(genders: Map<String, Boolean>, onClick: () -> Unit) {
    var i = 1
    for (gender in genders)
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(5.dp)
                .heightIn(min = 30.dp, max = 70.dp)
                .widthIn(min = 40.dp)
                .fillMaxHeight()
                .fillMaxWidth(countEqualDistance(genders.size, i++))
                .background(if (gender.value) PrussianBlue else PanelBlue)
                .clickable { onClick() }
        ) {
            InnerCardText(text = gender.key)
        }
}