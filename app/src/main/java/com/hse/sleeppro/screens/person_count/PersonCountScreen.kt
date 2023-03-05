package com.hse.sleeppro.screens.person_count

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.screens.person_count.model.PersonCountEvent
import com.hse.sleeppro.screens.person_count.model.PersonCountViewModel
import com.hse.sleeppro.ui.component.NavigationPanel
import com.hse.sleeppro.ui.component.cards.HumanCard
import com.hse.sleeppro.ui.component.cards.TwoHumanCard

@Composable
fun PersonCountScreen(personCountViewModel: PersonCountViewModel, navController: NavController) {
    val viewState = personCountViewModel.personCountViewState.observeAsState()

    when (val state = viewState.value) {
        is PersonCountViewState.Display -> {
            PersonCountDisplay(
                navController = navController,
                state,
                { personCountViewModel.obtainEvent(PersonCountEvent.ClickToOnePlace) },
                { personCountViewModel.obtainEvent(PersonCountEvent.ClickToTwoPlace) },
            )
        }

    }
}


@Composable
fun PersonCountDisplay(
    navController: NavController,
    state: PersonCountViewState.Display,
    onOneHumanClick: () -> Unit,
    onTwoHumanClick: () -> Unit
) {
    NavigationPanel(
        "NEXT",
        onNextButtonClick = { navController.navigate(MainScreen.Camera.route) },
        onPreviousButtonClick = {
            navController.navigate(MainScreen.Cards.route)
        },
        "BACKEND",
        reloadButtonText = "RELOAD",
        onReloadButtonClick = {}
    ) {
            Row(modifier = Modifier.fillMaxWidth().padding(top = 217.dp),horizontalArrangement = Arrangement.SpaceAround) {
                HumanCard(state) {
                    onOneHumanClick.invoke()
                }
                TwoHumanCard(state) {
                    onTwoHumanClick.invoke()
                }

        }
    }
}