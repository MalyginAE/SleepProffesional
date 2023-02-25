package com.hse.sleeppro.screens.forms.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hse.sleeppro.base.EventHandler
import com.hse.sleeppro.screens.forms.FormEvent
import com.hse.sleeppro.screens.forms.FormViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor() : ViewModel(), EventHandler<FormEvent> {

    private val _formViewState: MutableLiveData<FormViewState> = MutableLiveData(FormViewState.Display())
    val formViewState: LiveData<FormViewState> = _formViewState


    override fun obtainEvent(event: FormEvent) {
        when (val currentState = _formViewState.value) {
            is FormViewState.Loading -> reduce(currentState, event)
            is FormViewState.Display -> reduce(currentState, event)
            else -> {}
        }
    }

    private fun reduce(state: FormViewState.Display, event: FormEvent) {
        when (event) {
            is FormEvent.NameChanged -> _formViewState.postValue(
                state.copy(enterNameModel = state.enterNameModel.copy(text = event.newValue))
            )
            is FormEvent.EmailChanged -> _formViewState.postValue(
                state.copy(enterEmailModel =  state.enterEmailModel.copy(text = event.newEmail))
            )

            else -> {}
        }
    }

    private fun reduce(state: FormViewState.Loading, event: FormEvent) {
        //TODO("Not yet implemented")
    }

}