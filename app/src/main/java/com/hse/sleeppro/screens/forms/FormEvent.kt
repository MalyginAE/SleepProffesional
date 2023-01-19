package com.hse.sleeppro.screens.forms

sealed class FormEvent {
    object Loading: FormEvent()
    object SaveData : FormEvent()
    data class NameChanged(val newValue:String) : FormEvent()
    //object

}
