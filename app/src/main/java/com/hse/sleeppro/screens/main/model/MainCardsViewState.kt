package com.hse.sleeppro.screens.main.model

sealed class MainCardsViewState {
    data class Display(val sleepPositions: List<SleepPosition>)
}
