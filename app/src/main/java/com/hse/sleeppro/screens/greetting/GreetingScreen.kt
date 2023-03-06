package com.hse.sleeppro.screens.greetting

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hse.sleeppro.R
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.ui.component.button.StartButton

@Composable
fun GreetingScreen(navController: NavController) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.ascona_logo),
                contentDescription = "Logo company ",
                modifier = Modifier
                    .width(570.dp)
                    .height(150.dp)

                //   .heightIn(min = 50.dp, max = 150.dp)
                //  .widthIn(min = 50.dp, max = 150.dp)
            )
            StartButton("START",{ navController.navigate(MainScreen.Cards.route) })
        }
    }
//    Button(onClick = { navController.navigate(MainScreen.Cards.route) }) {
//        Log.d("Render","Render Text in GreeningScreen")
//        Text(text = "start")
//    }
}