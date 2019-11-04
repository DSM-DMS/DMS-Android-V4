package com.dsm.dms.presentation.viewmodel.sign.register

import com.dsm.dms.presentation.base.BaseViewModel
import io.reactivex.subjects.PublishSubject

class RegisterCompleteViewModel : BaseViewModel() {
    val completeSubject = PublishSubject.create<Unit>()

    fun completeClick() {
        completeSubject.onNext(Unit)
    }
}