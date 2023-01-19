package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.ui.theme.cardsFont


@Composable
fun CardTitle(title:String){
    Text(
        text = title,
        fontFamily = cardsFont,
        modifier = Modifier.padding(15.dp),
        color = Color(0xFF041950)
    )
}


@Composable
fun InnerCardText(text:String, modifier: Modifier = Modifier.padding(15.dp)){
    Text(
        text = text,
        fontFamily = cardsFont,
        modifier = modifier,
        color = Color.White
    )
}

