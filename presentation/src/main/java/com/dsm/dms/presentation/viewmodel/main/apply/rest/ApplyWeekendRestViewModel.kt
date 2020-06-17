package com.dsm.dms.presentation.viewmodel.main.apply.rest

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent


class ApplyWeekendRestViewModel: BaseViewModel() {
    val nowWeekendRest = MutableLiveData<String>()

    val weekendRestClickEvent = SingleLiveEvent<String>()
    val backToMainEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun backClick() = backToMainEvent.call()

    fun restAtAmClick() {
        weekendRestClickEvent.value = "am"
    }

    fun restAtPmClick() {
        weekendRestClickEvent.value = "pm"
    }
}
