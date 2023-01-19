package com.hse.sleeppro.screens.greetting

import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.hse.sleeppro.screens.main.MainScreen

@Composable
fun GreetingScreen(navController: NavController) {
    Button(onClick = { navController.navigate(MainScreen.Cards.route) }) {
        Log.d("Render","Render Text in GreeningScreen")
        Text(text = "start")
    }
}