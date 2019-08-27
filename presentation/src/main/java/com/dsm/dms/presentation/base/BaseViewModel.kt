package com.dsm.dms.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {

        compositeDisposable.clear()
        super.onCleared()
    }

    fun add(d: Disposable) = compositeDisposable.add(d)
}