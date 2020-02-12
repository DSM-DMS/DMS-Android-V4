package com.dsm.dms.presentation.viewmodel.main.apply.extension

import androidx.lifecycle.Lifecycle
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent

class ApplyExtensionFloorListViewModel: BaseViewModel() {
    val backToMainEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun firstFloorClick() {

    }

    fun secondFloorClick() {

    }

    fun thirdFloorClick() {

    }

    fun fourthFloorClick() {

    }

    fun fifthFloorClick() {

    }

    fun backClick() = backToMainEvent.call()
}