package com.hse.sleeppro.screens.person_count

sealed class PersonCountViewState {
    data class Display(val onePlace:Boolean, val twoPlace:Boolean):PersonCountViewState()
}