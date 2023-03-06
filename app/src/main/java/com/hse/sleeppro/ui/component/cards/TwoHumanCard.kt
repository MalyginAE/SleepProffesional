package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.R
import com.hse.sleeppro.screens.person_count.PersonCountViewState
import com.hse.sleeppro.ui.theme.Base100
import com.hse.sleeppro.ui.theme.Green500

@Composable
fun TwoHumanCard(state: PersonCountViewState.Display, modifier: Modifier = Modifier, onTwoHumanClick: ()->Unit){
    var color = Base100
    if (state.twoPlace)
        color = Green500
    Box(
        modifier = Modifier
            .size(350.dp, 350.dp)
            .border(2.dp, color, RoundedCornerShape(15.dp))
            .clickable { onTwoHumanClick.invoke() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.human_male_male),
            contentDescription = "human",
            modifier = Modifier
                .height(320.dp)
                .width(250.dp),
            contentScale = ContentScale.FillHeight,
            colorFilter = ColorFilter.tint(color)
        )
    }
}