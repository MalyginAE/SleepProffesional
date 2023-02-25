package com.hse.sleeppro.screens.forms

sealed class FormViewState {
    object Loading : FormViewState()
    data class Display(
        val enterNameModel: EnterTextCardModel = EnterTextCardModel(
            labelText = "Enter customer name",
            text = "",
            cardTitle = "Name",
           // isShowIconCheck = false
        ),
        val enterEmailModel: EnterTextCardModel = EnterTextCardModel(
            labelText = "Enter customer email",
            text = "",
            cardTitle = "Email",
            // isShowIconCheck = false
        ),
        val genderModel:GenderModel = GenderModel(GenderType.None),


        ) : FormViewState()
}

data class EnterTextCardModel(

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