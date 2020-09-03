package com.dsm.dms.domain

import com.dsm.dms.domain.base.ErrorHandler
import io.reactivex.Single
import com.dsm.dms.domain.base.Result
import io.reactivex.Completable


fun Completable.toSingleResult(
    handler: ErrorHandler
): Single<Result<Unit>> = this
    .toSingle { Unit }.toResult(handler)

fun <T> Completable.toSingleResult(
    handler: ErrorHandler,
    data: T,
    localFun: (T) -> Unit
): Single<Result<Unit>> = this
    .toSingle {
        localFun(data)
    }.toResult(handler)

fun <T> Single<T>.toResult(
    handler: ErrorHandler,
    getLocalDataFun: () -> T?,
    saveLocalFun: (T) -> Unit
): Single<Result<T>> = this
    .map {
        Result.Success(it) as Result<T>
    }
    .onErrorReturn {
        Result.Error(message = handler.errorHandle(it))
    }
    .processLocal(getLocalDataFun, saveLocalFun)

fun <T> Single<T>.toResult(
    handler: ErrorHandler
): Single<Result<T>> = this
    .map {
        Result.Success(it) as Result<T>
    }
    .onErrorReturn {
        Result.Error(null, handler.errorHandle(it))
    }


fun <T> Single<Result<T>>.processLocal(getLocalDataFun: () -> T?, saveLocalFun: (T) -> Unit): Single<Result<T>> = this
    .flatMap { result ->
        when(result) {
            is Result.Success -> {
                saveLocalFun(result.data)
                Single.just(result)
            }
            is Result.Error -> {
                val localData = getLocalDataFun()
                if (localData != null)
                    return@flatMap Single.just(
                        Result.Error(localData, result.message)
                    )
                Single.just(result)
            }
        }
    }
