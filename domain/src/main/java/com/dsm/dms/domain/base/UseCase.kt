package com.dsm.dms.domain.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, E>(private val composite: CompositeDisposable) {

    abstract fun create(data: T): Single<E>

    fun execute(data: T, singleObserver: DisposableSingleObserver<E>) {
        val observer =
            create(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(singleObserver)

        composite.add(observer)
    }

    fun clear() = composite.clear()
}