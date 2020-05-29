package com.dsm.dms.presentation.viewmodel.sign.login

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import io.reactivex.subjects.PublishSubject

class LoginViewModel : BaseViewModel() {
    val loginSingleLiveEvent = SingleLiveEvent<Unit>()
    val registerSingleLiveEvent = SingleLiveEvent<Unit>()
    val idLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun loginClick() {
        loginSingleLiveEvent.call()
    }

    fun registerClick() {
        registerSingleLiveEvent.call()
    }
}