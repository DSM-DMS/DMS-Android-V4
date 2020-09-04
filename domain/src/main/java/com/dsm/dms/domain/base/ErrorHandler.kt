package com.dsm.dms.domain.base

interface ErrorHandler {
    fun errorHandle(throwable: Throwable): Message
}
