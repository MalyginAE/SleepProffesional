package com.hse.sleeppro.ui.component.button

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hse.sleeppro.ui.theme.Base0
import com.hse.sleeppro.ui.theme.Base100
import com.hse.sleeppro.ui.theme.cardsFont
import com.hse.sleeppro.ui.theme.robotoFont

@Composable
fun BackButton(backTextButton: String, onPreviousButtonClick: () -> Unit) {

    Box(
        modifier = Modifier
            .widthIn(min = 100.dp)
            .fillMaxWidth(0.15f)
            .height(40.dp)
            .background(Base0)
            .border(2.dp, Base100,RoundedCornerShape(15.dp))
            .clickable {
                Log.d("back button clicked", "back button back was clicked")
                onPreviousButtonClick.invoke()
            }
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Base100,
                modifier = Modifier.offset(y = 6.dp)
            )
            Text(text = backTextButton, fontFamily = robotoFont, fontSize = 20.sp, color = Base100)
        }
    }

}