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
        val genderModel:GenderModel = GenderModel("Male"),
        val sleepPositionModel:SleepPositionModel = SleepPositionModel(
            "Back", "SleepPosition"
        ),


        ) : FormViewState()
}

data class EnterTextCardModel(
    val text: String,
    val cardTitle: String,
    val labelText: String,
    )

data class SleepPositionModel(
    val position: String,
    val cardTitle: String,
    val expanded:Boolean = false,
    val positionTypes: List<String> = listOf("Back", "Front","Side"),

)

data class GenderModel(
    val gender:String,
    val expanded:Boolean = false,
    val genderTypes: List<String> = listOf("Male", "Female"),


)

enum class GenderType(type:String){
    Male("Male"),Female("Female"), None("None")
}