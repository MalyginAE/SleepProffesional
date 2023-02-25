package com.hse.sleeppro.screens.forms

sealed class FormEvent {
    object Loading : FormEvent()
    object SaveData : FormEvent()
    data class NameChanged(val newValue: String) : FormEvent()
    data class EmailChanged(val newEmail: String) : FormEvent()
    data class ClickToGender(val state: Boolean) : FormEvent()
    data class ClickToSleepPosition(val state: Boolean) : FormEvent()
    data class ClickToDiscomforts(val state: Boolean) : FormEvent()
    data class ClickToReducers(val state: Boolean) : FormEvent()
}
