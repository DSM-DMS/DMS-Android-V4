package com.dsm.dms.presentation.viewmodel.main.apply.extension

import androidx.lifecycle.Lifecycle
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent

class ApplyExtensionFloorListViewModel: BaseViewModel() {
    val backToMainEvent = SingleLiveEvent<Unit>()
    val goToDetailEvent = SingleLiveEvent<Int>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun floorClick(floor: Int) {
        goToDetailEvent.value = floor
    }

    fun backClick() = backToMainEvent.call()
}