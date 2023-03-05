package com.hse.sleeppro.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hse.sleeppro.ui.theme.Base0
import com.hse.sleeppro.ui.theme.Base100
import com.hse.sleeppro.ui.theme.Green500
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.cardsFont
import com.hse.sleeppro.ui.theme.robotoFont


enum class NextButtonState (){
    ENABLED,DISABLED
}

@Composable
fun NextButton(state: NextButtonState,textButton:String , onNextButtonClick: () -> Unit) {
    if (state.equals(NextButtonState.DISABLED))
    DisabledNextButton(textButton = textButton) {
        onNextButtonClick.invoke()
    }
    else{
        EnabledNextButton(textButton = textButton) {
            onNextButtonClick.invoke()
        }
    }

}
@Composable
private fun DisabledNextButton(textButton:String , onNextButtonClick: () -> Unit){
    Box(
        modifier = Modifier
            .widthIn(min = 100.dp)
            .fillMaxWidth(0.2f)
            .padding(start = 10.dp)
            .height(40.dp)
            .background(Base100, RoundedCornerShape(15.dp))
//            .clickable { onNextButtonClick.invoke() }
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = textButton, fontFamily = robotoFont, fontSize = 20.sp, color = Base0)
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "",
                tint = Base0,

                modifier = Modifier
                    .padding(start = 5.dp)
                    .offset(y = 6.dp)
            )
        }
    }

}


@Composable
private fun EnabledNextButton(textButton:String , onNextButtonClick: () -> Unit) {
    Box(
        modifier = Modifier
            .widthIn(min = 100.dp)
            .fillMaxWidth(0.2f)
            .padding(start = 10.dp)
            .height(40.dp)
            .background(Green500, RoundedCornerShape(15.dp))
            .clickable { onNextButtonClick.invoke() }
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = textButton, fontFamily = robotoFont, fontSize = 20.sp, color = Base0)
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "",
                tint = Base0,

                modifier = Modifier
                    .padding(start = 5.dp)
                    .offset(y = 6.dp)
            )
        }
    }
}