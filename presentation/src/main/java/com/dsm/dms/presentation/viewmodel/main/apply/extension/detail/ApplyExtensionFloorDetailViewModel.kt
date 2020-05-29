package com.dsm.dms.presentation.viewmodel.main.apply.extension.detail

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent


class ApplyExtensionFloorDetailViewModel: BaseViewModel() {

    val backToListEvent = SingleLiveEvent<Unit>()
    val setTitleEvent = SingleLiveEvent<Int>()
    val setFirstFloorRoomsEvent = SingleLiveEvent<Unit>()
    val setSecondFloorRoomsEvent = SingleLiveEvent<Unit>()
    val setThirdFloorRoomsEvent = SingleLiveEvent<Unit>()
    val setFourthFloorRoomsEvent = SingleLiveEvent<Unit>()
    val setFifthFloorRoomsEvent = SingleLiveEvent<Unit>()

    val changeNewRoomEvent = SingleLiveEvent<String>()
    val changeOldRoomEvent = SingleLiveEvent<String>()

    val elevenClockEvent = SingleLiveEvent<Pair<Boolean, Boolean>>()
    val twelveClockEvent = SingleLiveEvent<Pair<Boolean, Boolean>>()

    val changeMapEvent = SingleLiveEvent<ArrayList<ArrayList<out Any>>>()

    val nowFloor = MutableLiveData<Int>()
    val nowRoom = MutableLiveData<String>()
    val nowClock = MutableLiveData<String>()

    val selectedSeatNum = MutableLiveData<Int>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_START -> {
                setTitleEvent.value = nowFloor.value
                setRooms()
            }
        }
    }

    fun elevenClockClick() {
        elevenClockEvent.value = (nowClock.value != "11") to (nowClock.value == "11")
        nowClock.value = "11"
    }

    fun twelveClockClick() {
        twelveClockEvent.value = (nowClock.value != "12") to (nowClock.value == "12")
        nowClock.value = "12"
    }

    fun backClick() = backToListEvent.call()

    fun changeRoom(roomName: String) {
        nowRoom.value?.let {
            if (roomName != it) {
                changeNewRoomEvent.value = roomName
                changeOldRoomEvent.value = it
            }
        }.let {
            changeNewRoomEvent.value = roomName
        }
        nowRoom.value = roomName
    }

    private fun setRooms() {
        when(nowFloor.value) {
            1 -> setFirstFloorRoomsEvent.call()
            2 -> setSecondFloorRoomsEvent.call()
            3 -> setThirdFloorRoomsEvent.call()
            4 -> setFourthFloorRoomsEvent.call()
            5 -> setFifthFloorRoomsEvent.call()
        }
        elevenClockClick()

        changeMapEvent.value = arrayListOf(
            arrayListOf(
                "송진우", 2, 0, 3, 4
            ),
            arrayListOf(
                5, 6, 0, 7, 8
            ),
            arrayListOf(
                9, 10, 0, 11, 12
            ),
            arrayListOf(
                13, 14, 0, 15, 16
            ),
            arrayListOf(
                17, 18, 0, 19, 20
            )
        )
    }
}
