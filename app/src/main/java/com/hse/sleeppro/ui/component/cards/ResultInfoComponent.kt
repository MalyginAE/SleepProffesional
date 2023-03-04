package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hse.sleeppro.R
import com.hse.sleeppro.ui.theme.Base0
import com.hse.sleeppro.ui.theme.robotoFont

@Composable
@Preview
fun ResultInfo() {
//    Box(modifier =Modifier.fillMaxWidth(), Alignment.Center) {
    Row(modifier = Modifier.padding(start = 51.dp, top = 37.dp)) {
        Image(
            painter = painterResource(id = R.drawable.check_circle),
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
//    }
}