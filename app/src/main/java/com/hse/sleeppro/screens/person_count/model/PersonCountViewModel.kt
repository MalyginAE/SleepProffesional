package com.hse.sleeppro.screens.person_count.model

import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hse.sleeppro.base.EventHandler
import com.hse.sleeppro.screens.forms.FormEvent
import com.hse.sleeppro.screens.forms.FormViewState
import com.hse.sleeppro.screens.person_count.PersonCountViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonCountViewModel @Inject constructor() : ViewModel(), EventHandler<PersonCountEvent> {

    private val _personCountViewState: MutableLiveData<PersonCountViewState> = MutableLiveData(PersonCountViewState.Display(false,
        twoPlace = false
    ))
    val personCountViewState: LiveData<PersonCountViewState> = _personCountViewState


    override fun obtainEvent(event: PersonCountEvent) {
        when (val currentState = _personCountViewState.value) {
            is PersonCountViewState.Display -> reduce(currentState, event)
            else -> {}
        }

    }

    private fun reduce(state: PersonCountViewState.Display, event: PersonCountEvent) {
        when (event) {
            is PersonCountEvent.ClickToOnePlace -> _personCountViewState.postValue(
                state.copy(onePlace = !state.onePlace)
            )
            is PersonCountEvent.ClickToTwoPlace -> _personCountViewState.postValue(
                state.copy(twoPlace = !state.twoPlace)
            )


        }
    }
}
