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
               // GenderCard(genderList, onClick)
            }
        }
    }
}

