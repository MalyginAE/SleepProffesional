package com.hse.sleeppro.screens.forms

sealed class FormEvent {
    object Loading : FormEvent()
    object SaveData : FormEvent()
    object DismissRequestGenderModel : FormEvent()
    object DismissRequestSleepPositionModel : FormEvent()
    data class NameChanged(val newValue: String) : FormEvent()
    data class EmailChanged(val newEmail: String) : FormEvent()
    data class ClickToGenderItem(val newValue: String):FormEvent()
    object ClickToGender : FormEvent()
    object ClickToSleepPosition : FormEvent()
    data class ClickToSleepPositionItem(val newValue: String):FormEvent()
    data class ClickToDiscomforts(val state: Boolean) : FormEvent()
    data class ClickToReducers(val state: Boolean) : FormEvent()
}
