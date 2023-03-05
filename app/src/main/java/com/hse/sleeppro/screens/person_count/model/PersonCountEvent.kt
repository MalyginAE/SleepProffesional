package com.hse.sleeppro.screens.person_count.model

sealed class PersonCountEvent {
    object ClickToOnePlace:PersonCountEvent()
    object ClickToTwoPlace:PersonCountEvent()
}
