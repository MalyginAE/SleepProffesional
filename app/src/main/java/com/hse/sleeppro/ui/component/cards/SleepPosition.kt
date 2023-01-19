package com.hse.sleeppro.ui.component.cards

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.screens.main.model.SleepPosition
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.PanelGray
import com.hse.sleeppro.ui.theme.PrussianBlue
import com.hse.sleeppro.ui.util.countEqualDistance

@Composable
fun SleepPosition(sleepPosition: List<SleepPosition>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .background(PanelGray)
    ) {
        Column() {
            CardTitle(title = "Sleep Position")
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
            ) {
                SleepPositionCard(sleepPosition)
            }
        }
    }
}

@Composable
private fun SleepPositionCard(sleepPositions:List<SleepPosition>) {
    var i = 1
    for (sleepPosition in sleepPositions)
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(5.dp)
                .heightIn(min = 30.dp, max = 70.dp)
                .widthIn(min = 40.dp)
                .fillMaxHeight()
                .fillMaxWidth(countEqualDistance(sleepPositions.size, i++))
                .background(
                    sleepPosition.onChoseBackgroundColor()
                )
                .clickable {
                  //  Log.d("asas",sleepPosition.currentIndex.toString())
                    Log.d("asas2",sleepPosition.toString())
                sleepPosition.onClick()
                }
        ) {
            InnerCardText(text = sleepPosition.text)
        }
}
