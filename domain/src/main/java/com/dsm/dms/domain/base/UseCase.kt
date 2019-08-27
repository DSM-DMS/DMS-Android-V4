package com.dsm.dms.domain.base

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

abstract class UseCase<T, E>(val composite: CompositeDisposable) {

    abstract fun createFlowable(data: E): Flowable<T>

    fun execute(data: E, disposableObserver: DisposableSubscriber<T>) {
        val observable = createFlowable(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val observer = observable.subscribeWith(disposableObserver)

        composite.add(observer)
    }

    fun clear() = composite.clear()
}