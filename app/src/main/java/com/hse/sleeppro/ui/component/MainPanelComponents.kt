package com.hse.sleeppro.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.PrussianBlue

@Composable
fun NavigationPanel(
    nextButtonText: String,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit,
    previousButtonText: String,
    cards: @Composable () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row {
            LeftInfoPanel()
            ContentWithNavigationButton(
                cards,
                nextButtonText,
                onNextButtonClick,
                onPreviousButtonClick,
                previousButtonText
            )
        }
    }
}

@Composable
fun ContentWithNavigationButton(
    cards: @Composable () -> Unit,
    nextButtonText: String,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit,
    previousButtonText: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 30.dp, start = 30.dp)
    ) {
        Column {
            RestartButton()
            Box(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxHeight(0.8f)
            ) {
                cards()
            }
            NavigationButton(
                nextButtonText,
                onNextButtonClick,
                onPreviousButtonClick,
                previousButtonText
            )
        }
    }
}

//
//@Composable
//fun Cards(viewModel: MainViewModel = viewModel()) {
//    val viewState = viewModel.sleepPosition.observeAsState()
//    Log.d("viewModel", viewModel.toString())
//    Row() {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth(0.5f)
//                .padding(end = 10.dp)
//        ) {
//            val text = remember {
//                mutableStateOf("")
//            }
//            val gender = remember {
//                mutableStateMapOf("Female" to true, "Male" to false)
//            }
//            EnterName(text.value) { newText ->
//                text.value = newText
//            }
//            EnterGender(gender) {
//                gender["Female"] = !gender["Female"]!!
//                gender["Male"] = !gender["Male"]!!
//            }
//
//            //viewState.value?.let { SleepPosition(it) }
//            SleepPosition(sleepPosition = viewState.value!!.sleepPositions)
//        }
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(start = 10.dp)
//        ) {
//
//
//            RightSurveyCardsPanel(
//                "Discomforts", listOf(
//                    listOf(
//                        SurveyCards("Neck"),
//                        SurveyCards("Shoulders"),
//                        SurveyCards("Upper Back")
//                    ),
//                    listOf(SurveyCards("Lower Back"), SurveyCards("Hips"), SurveyCards("Legs"))
//                ),
//                0.5f
//            )
//            RightSurveyCardsPanel(
//                "Reducers", listOf(
//                    listOf(
//                        SurveyCards("Too Firm"),
//                        SurveyCards("Too Hot"),
//                        SurveyCards("Allergies")
//                    ),
//                    listOf(
//                        SurveyCards("Too Soft"),
//                        SurveyCards("Too Cold"),
//                        SurveyCards("Sleep Apnea")
//                    )
//                )
//            )
//        }
//
//    }
//}
//

data class SurveyCards(
    val text: String,
    val isChosen: MutableState<Boolean> = mutableStateOf(false),
    val onClick: () -> Unit = { isChosen.value = !isChosen.value },
    val onChoseBackgroundColor: () -> Color = { if (isChosen.value) PanelBlue else PrussianBlue }
)









