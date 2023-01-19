package com.hse.sleeppro.screens.forms

import androidx.compose.foundation.text.KeyboardActions

sealed class FormViewState {
    object Loading : FormViewState()
    data class Display(
        val enterNameModel: EnterNameModel = EnterNameModel(
            labelText = "Enter customer name",
            text = "",
            cardTitle = "Name",
           // isShowIconCheck = false
        ),
        val genderModel:GenderModel = GenderModel(GenderType.None),


        ) : FormViewState()
}

data class EnterNameModel(

    val text: String,
   // val isShowIconCheck:Boolean,
    val cardTitle: String,
    val labelText: String,
   // val trailingIcon: () -> Unit,

    )

data class GenderModel(
    val gender:GenderType
)

enum class GenderType(type:String){
    Male("Male"),Female("Female"), None("None")
}