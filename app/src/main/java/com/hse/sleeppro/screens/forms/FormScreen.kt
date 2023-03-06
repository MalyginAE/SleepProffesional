package com.hse.sleeppro.screens.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavController
import com.hse.sleeppro.screens.forms.model.FormViewModel
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.ui.component.LeftInfoPanel
import com.hse.sleeppro.ui.component.NavigationPanel
import com.hse.sleeppro.ui.component.cards.EnterOnePossibleChoise
import com.hse.sleeppro.ui.component.cards.EnterText

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FormScreen(
    navController: NavController,

    modifier: Modifier = Modifier,
    formViewModel: FormViewModel
) {
    val viewState = formViewModel.formViewState.observeAsState()

    val keyboardController = LocalSoftwareKeyboardController.current


    when (val state = viewState.value) {
        FormViewState.Loading -> LeftInfoPanel()
        is FormViewState.Display -> FormViewDisplay(
            viewState = state,
            navController = navController,
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                },
                onGo = {
                    keyboardController?.hide()
                }
            ),

            onNameChanged = { formViewModel.obtainEvent(FormEvent.NameChanged(it)) },
            onEmailChanged = { formViewModel.obtainEvent(FormEvent.EmailChanged(it)) },


            )
    }


}

@Composable
fun FormViewDisplay(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewState: FormViewState.Display,
    keyboardActions: KeyboardActions,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,

) {
    val nameModel = viewState.enterNameModel
    val emailModel = viewState.enterEmailModel
    NavigationPanel(
        "Next",
        onNextButtonClick = { navController.navigate(MainScreen.PersonCount.route) },
        onPreviousButtonClick = {
            navController.navigate(MainScreen.Greeting.route)
        },
        "Back",
        reloadButtonText = "Reload",
        onReloadButtonClick = {}
    ) {

        Column() {
            EnterText(
                text = nameModel.text,
                onValueChanged = onNameChanged,
                cardTitle = nameModel.cardTitle,
                labelText = nameModel.labelText,
                keyboardActions = keyboardActions
            )

            EnterText(
                text = emailModel.text,
                onValueChanged = onEmailChanged,
                cardTitle = emailModel.cardTitle,
                labelText = emailModel.labelText,
                keyboardActions = keyboardActions
            )

        }


    }


}


