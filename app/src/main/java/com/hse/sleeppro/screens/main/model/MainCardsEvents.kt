package com.hse.sleeppro.screens.main.model

sealed class MainCardsEvents {
    data class onSleepPositionClick(
    var position: Position
    ) : MainCardsEvents()
}