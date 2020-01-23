package com.dsm.dms.presentation.viewmodel.sign.register

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent

class RegisterViewModel : BaseViewModel() {
    val backSingleLiveEvent = SingleLiveEvent<Unit>()
    val nextSingleLiveEvent = SingleLiveEvent<Unit>()
    val completeSingleLiveEvent = SingleLiveEvent<Unit>()
    val idLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val retryPasswordLiveData = MutableLiveData<String>()
    val certifyCodeLiveData = MutableLiveData<String>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun backClick() {
        backSingleLiveEvent.call()
    }

    fun nextClick() {
        nextSingleLiveEvent.call()
    }

    fun completeClick() {
        completeSingleLiveEvent.call()
    }
}