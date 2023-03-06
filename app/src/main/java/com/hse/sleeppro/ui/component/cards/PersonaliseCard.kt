package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hse.sleeppro.R
import com.hse.sleeppro.ui.theme.Base0
import com.hse.sleeppro.ui.theme.Base900
import com.hse.sleeppro.ui.theme.robotoFont
enum class CardState{
    ACTIVE,PASSIVE
}
@Composable
fun PersonaliseCard(cardState: CardState) {
    when(cardState){
         CardState.ACTIVE -> PersonaliseCardActive()
         CardState.PASSIVE -> PersonaliseCardPassive()
    }
}

@Composable
@Preview(showBackground = true)
fun PersonaliseCardPassive() {
    Row(modifier = Modifier.padding(start = 51.dp, top = 37.dp)) {
        Image(
            painter = painterResource(id = R.drawable.account),
            contentDescription = "result",
            colorFilter = ColorFilter.tint(Base0),
            modifier = Modifier
//                    .background(color = Base900)
                .padding(start = 20.dp, top = 14.dp, bottom = 14.dp)
                .width(30.67.dp)
                .height(30.67.dp)
        )
        Text(
            text = "Result",
            fontFamily = robotoFont,
            fontSize = 24.sp,
            color = Base0,
            modifier = Modifier.padding(top = 15.dp, bottom = 15.dp, end = 12.dp, start = 20.dp),
        )
    }
}

@Composable
private fun PersonaliseCardActive(){
    Box(modifier =Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Card(shape = RoundedCornerShape(15.dp), elevation = 15.dp) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.account),
                    contentDescription = "account",
                    colorFilter = ColorFilter.tint(Base900),
                    modifier = Modifier
//                    .background(color = Base900)
                        .padding(start = 20.dp, top = 14.dp, bottom = 14.dp)
                        .width(30.67.dp)
                        .height(30.67.dp)
                )
                Text(
                    text = "Personalise",
                    fontFamily = robotoFont,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 15.dp, bottom = 15.dp, end = 12.dp, start = 20.dp),
                )
            }
        }
    }
}