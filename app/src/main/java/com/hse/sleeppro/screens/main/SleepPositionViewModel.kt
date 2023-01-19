package com.hse.sleeppro.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hse.sleeppro.base.EventHandler
import com.hse.sleeppro.screens.main.model.MainCardsEvents
import com.hse.sleeppro.screens.main.model.MainCardsViewState
import com.hse.sleeppro.screens.main.model.Position
import com.hse.sleeppro.screens.main.model.SleepPosition
import com.hse.sleeppro.ui.theme.PanelBlue
import com.hse.sleeppro.ui.theme.PrussianBlue



class SleepPositionViewModel : ViewModel(), EventHandler<MainCardsEvents>{
    private var position =  Position.Back

    private val sleepPositions =
          listOf(
               SleepPosition("Hello", position, {reduce()
               }, {
                    when (position) {
                         Position.Back -> PanelBlue
                         else -> {
                              PrussianBlue
                         }
                    }
               }),
               SleepPosition("Nexign", position, {
                    position = Position.Front
               }, {
                    when (position) {
                         Position.Front -> PanelBlue
                         else -> {
                              PrussianBlue
                         }
                    }
               }),
               SleepPosition("World", position, {
                    position = Position.Side
               }, {
                    when (position) {
                         Position.Side -> PanelBlue
                         else -> {
                              PrussianBlue
                         }
                    }
               }),
          )


    private var position2 =  Position.Back

//    private val sleepPositions2 =
//        listOf(
//            SleepPosition("He", position2, {
//            }, {
//                when (position2) {
//                    Position.Back -> PanelBlue
//                    else -> {
//                        PrussianBlue
//                    }
//                }
//            }),
//            SleepPosition("He", position2, {
//                position2 = Position.Front
//            }, {
//                when (position2) {
//                    Position.Front -> PanelBlue
//                    else -> {
//                        PrussianBlue
//                    }
//                }
//            }),
//            SleepPosition("He", position2, {
//                position2 = Position.Side
//            }, {
//                when (position2) {
//                    Position.Side -> PanelBlue
//                    else -> {
//                        PrussianBlue
//                    }
//                }
//            }),
//        )

    private val _sleepPosition = MutableLiveData(MainCardsViewState.Display(sleepPositions))
     val sleepPosition: LiveData<MainCardsViewState.Display>
          get() {
             return  _sleepPosition
          }

     override fun obtainEvent(event: MainCardsEvents) {
//          when(event){
//              is MainCardsEvents.onSleepPositionClick -> _sleepPosition.postValue()
//
//          }
     }

     fun reduce(){
         obtainEvent(MainCardsEvents.onSleepPositionClick(Position.Side))
     }

}

