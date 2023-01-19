package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.ui.component.SurveyCards
import com.hse.sleeppro.ui.theme.PanelGray
import com.hse.sleeppro.ui.theme.PrussianBlue
import com.hse.sleeppro.ui.theme.cardsFont
import com.hse.sleeppro.ui.util.countEqualDistance


@Composable
fun RightSurveyCardsPanel(cardsTitle:String, cardsNamesList: List<List<SurveyCards>>, maxHeightFraction:Float = 1f) {
    Box(
        modifier = Modifier
            .fillMaxHeight(maxHeightFraction)
            .padding(top = 10.dp)
            .background(PanelGray)
    ) {
        Column() {
            CardTitle(title = cardsTitle)

            for (rowCardsNameList in cardsNamesList)
                RowCardsRender(rowCardsNameList)
        }
    }
}


@Composable
private fun RowCardsRender(list: List<SurveyCards>) {
    Row(
        modifier = Modifier
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        var i = 1
        for (name in list) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 5.dp, end = 1.dp)
                    .heightIn(min = 30.dp, max = 80.dp)
                    .widthIn(min = 40.dp)
                    .fillMaxWidth(countEqualDistance(list.size, i++))
                    .background(name.onChoseBackgroundColor())
                    .clickable {
                    name.onClick()
                    }
            ) {
                Text(
                    text = name.text,
                    fontFamily = cardsFont,
                    modifier = Modifier.padding(15.dp),
                    color = Color.White
                )
            }
        }
    }
}

