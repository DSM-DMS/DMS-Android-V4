package com.dsm.dms.domain.base

sealed class Result<T> {

    data class Success<T>(val data: T): Result<T>()

    data class Error<T>(
        var data: T?,
        var message: Message
    ): Result<T>()

}
