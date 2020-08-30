package com.mohaeyo.domain.base

data class ErrorHandlerEntity(
    val message: String = "",
    val isSuccess: Boolean = false
)