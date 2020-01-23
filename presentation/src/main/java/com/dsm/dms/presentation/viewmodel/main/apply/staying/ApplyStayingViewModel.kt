package com.dsm.dms.presentation.viewmodel.main.apply.staying

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent

class ApplyStayingViewModel: BaseViewModel() {
    val nowStayingState = MutableLiveData<String>()

    val cardChangeColorEvent = SingleLiveEvent<String>()
    val backToMainEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun fridayGoClick() {
        cardChangeColorEvent.value = "금요귀가"
    }

    fun saturdayGoClick() {
        cardChangeColorEvent.value = "토요귀가"
    }

    fun saturdayBackClick() {
        cardChangeColorEvent.value = "토요귀사"
    }

    fun stayingClick() {
        cardChangeColorEvent.value = "잔류"
    }

    fun backClick() = backToMainEvent.call()
}