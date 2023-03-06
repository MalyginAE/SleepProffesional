package com.hse.sleeppro.screens.person_count

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hse.sleeppro.screens.main.MainScreen
import com.hse.sleeppro.screens.person_count.model.PersonCountEvent
import com.hse.sleeppro.screens.person_count.model.PersonCountViewModel
import com.hse.sleeppro.ui.component.NavigationPanel
import com.hse.sleeppro.ui.component.cards.AnalysisInfo
import com.hse.sleeppro.ui.component.cards.CardState
import com.hse.sleeppro.ui.component.cards.HumanCard
import com.hse.sleeppro.ui.component.cards.PersonaliseCard
import com.hse.sleeppro.ui.component.cards.ResultInfo
import com.hse.sleeppro.ui.component.cards.ScanInfo
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
        "Next",
        onNextButtonClick = { navController.navigate(MainScreen.Camera.route) },
        onPreviousButtonClick = {
            navController.navigate(MainScreen.Cards.route)
        },
        "Back",
        reloadButtonText = "Reload",
        onReloadButtonClick = {},
        panelCards = {
            PersonaliseCard(cardState = CardState.ACTIVE)
            AnalysisInfo(state = CardState.PASSIVE)
            ScanInfo()
            ResultInfo()
        }
    ) {
            Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(),horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
                HumanCard(state, modifier = Modifier.fillMaxWidth(0.5f).padding(end = 5.dp)) {
                    onOneHumanClick.invoke()
                }
                TwoHumanCard(state,modifier = Modifier.fillMaxWidth(1f)) {
                    onTwoHumanClick.invoke()
                }

        }
    }
}