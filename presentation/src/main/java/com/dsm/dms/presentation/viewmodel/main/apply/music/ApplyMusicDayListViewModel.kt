package com.dsm.dms.presentation.viewmodel.main.apply.music

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent


class ApplyMusicDayListViewModel: BaseViewModel() {
    val mondaySize = MutableLiveData<String>().apply { value = "1" }
    val tuesdaySize = MutableLiveData<String>().apply { value = "1" }
    val wednesdaySize = MutableLiveData<String>().apply { value = "1" }
    val thursdaySize = MutableLiveData<String>().apply { value = "1" }
    val fridaySize = MutableLiveData<String>().apply { value = "1" }

    val backToMain = SingleLiveEvent<Unit>()
    val goDetailDayEvent = SingleLiveEvent<String>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun dayClick(day: String) {
        goDetailDayEvent.value = day
    }

    fun backClick() = backToMain.call()
}
