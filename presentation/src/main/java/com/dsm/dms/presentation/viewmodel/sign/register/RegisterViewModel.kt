package com.dsm.dms.presentation.viewmodel.sign.register

import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import io.reactivex.subjects.PublishSubject

class RegisterViewModel : BaseViewModel() {
    val backSubject = PublishSubject.create<Unit>()
    val nextSubject = PublishSubject.create<Unit>()
    val idLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val retryPasswordLiveData = MutableLiveData<String>()
    val certifyCodeLiveData = MutableLiveData<String>()

    fun backClick() {
        backSubject.onNext(Unit)
    }

    fun nextClick() {
        nextSubject.onNext(Unit)
    }
}