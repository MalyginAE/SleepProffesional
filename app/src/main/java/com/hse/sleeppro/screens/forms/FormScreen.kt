package com.hse.sleeppro.screens.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavController
import com.hse.sleeppro.screens.forms.EnterNameModel
import com.hse.sleeppro.screens.forms.FormEvent
import com.hse.sleeppro.screens.forms.FormViewState
import com.hse.sleeppro.screens.forms.model.FormViewModel
import com.hse.sleeppro.ui.component.LeftInfoPanel
import com.hse.sleeppro.ui.component.NavigationPanel
import com.hse.sleeppro.ui.component.cards.EnterGender
import com.hse.sleeppro.ui.component.cards.EnterName

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

            onValueChanged = { formViewModel.obtainEvent(FormEvent.NameChanged(it)) }


        )
        else -> {}
    }


}

@Composable
fun FormViewDisplay(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewState: FormViewState.Display,
    keyboardActions: KeyboardActions,
    onValueChanged: (String) -> Unit,

   // onNextButtonClick: () -> Unit,
    //onPreviousButtonClick: () -> Unit,
) {
    val model = viewState.enterNameModel
    NavigationPanel(
        "next",
        onNextButtonClick = {navController.navigate(MainScreen.Camera.route)},
        onPreviousButtonClick = { navController.previousBackStackEntry?.let { navController.navigate(it.id) } },
        "backend"
    ) {

            EnterName(
                text = model.text,
                onValueChanged = onValueChanged,
                cardTitle = model.cardTitle,
                labelText = model.labelText,
                keyboardActions = keyboardActions
            )



    }


}


