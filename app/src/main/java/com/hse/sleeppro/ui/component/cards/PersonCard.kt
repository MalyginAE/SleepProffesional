package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.R
import com.hse.sleeppro.ui.theme.PanelGray

@Composable
fun PersonCard() {
    Box(
        modifier = Modifier
            .background(PanelGray)
            .fillMaxWidth(0.5f)
            .fillMaxHeight()
            .clickable {

            }
    ) {
        CardTitle(title = "Choose Single")
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Row() {
                Image(
                    painter = painterResource(id = R.drawable.person_svgrepo_com),
                    contentDescription = "Andy Rubin",
                    modifier = Modifier
                        .heightIn(min = 50.dp, max = 150.dp)
                        .widthIn(min = 50.dp, max = 150.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.person_svgrepo_com),
                    contentDescription = "Andy Rubin",
                    modifier = Modifier
                        .heightIn(min = 50.dp, max = 150.dp)
                        .widthIn(min = 50.dp, max = 150.dp)
                )
            }
        }
    }

}


@Composable
fun TwoPersonCard() {
    Box(
        modifier = Modifier
            .background(PanelGray)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        CardTitle(title = "Choose Two")
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.person_svgrepo_com),
                contentDescription = "Andy Rubin",
                modifier = Modifier
                    .heightIn(min = 50.dp, max = 150.dp)
                    .widthIn(min = 50.dp, max = 400.dp)
            )
        }
    }

}
