package com.dsm.dms.presentation.model

import com.dsm.dms.domain.entity.Auth


data class AuthModel(
    var id: String,
    var password: String,
    var email: String
)

fun AuthModel.toEntity() =
    Auth(
        id = id,
        password = password,
        email = email
    )

fun Auth.toModel() =
    AuthModel(
        id = id,
        password = password,
        email = email
    )
