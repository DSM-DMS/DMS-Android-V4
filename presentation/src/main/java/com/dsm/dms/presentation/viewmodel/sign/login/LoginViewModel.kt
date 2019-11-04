package com.dsm.dms.presentation.viewmodel.sign.login

import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import io.reactivex.subjects.PublishSubject

class LoginViewModel : BaseViewModel() {
    val loginSubject = PublishSubject.create<Unit>()
    val registerSubject = PublishSubject.create<Unit>()
    val idLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()

    fun loginClick() {
        loginSubject.onNext(Unit)
    }

    fun registerClick() {
        registerSubject.onNext(Unit)
    }
}