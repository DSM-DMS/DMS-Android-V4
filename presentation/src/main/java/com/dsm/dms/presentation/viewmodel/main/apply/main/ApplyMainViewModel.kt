package com.dsm.dms.presentation.viewmodel.main.apply.main

import androidx.lifecycle.Lifecycle
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent

class ApplyMainViewModel: BaseViewModel() {
    val goStayingEvent = SingleLiveEvent<Unit>()
    val goStudyingEvent = SingleLiveEvent<Unit>()
    val goGoingOutEvent = SingleLiveEvent<Unit>()
    val goMusicEvent = SingleLiveEvent<Unit>()
    val goRestEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun stayingClick() = goStayingEvent.call()

    fun studyingClick() = goStudyingEvent.call()

    fun goingOutClick() = goGoingOutEvent.call()

    fun musicClick() = goMusicEvent.call()

    fun restClick() = goRestEvent.call()
}