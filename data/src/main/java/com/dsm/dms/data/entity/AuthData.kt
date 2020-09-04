package com.dsm.dms.data.entity

import com.dsm.dms.data.dto.request.SignInRequest
import com.dsm.dms.data.dto.request.SignUpRequest
import com.dsm.dms.data.dto.request.TemporaryPasswordRequest
import com.dsm.dms.domain.entity.Auth


data class AuthData(
    var id: String,
    var password: String,
    var email: String
)

fun Auth.toDataEntity() =
    AuthData(
        id = id,
        password = password,
        email = email
    )

fun AuthData.toEntity() =
    Auth(
        id = id,
        password = password,
        email = email
    )

fun AuthData.toSignInRequest() =
    SignInRequest(
        id = id,
        password = password
    )

fun AuthData.toSignUpRequest() =
    SignUpRequest(
        id = id,
        password = password
    )

fun AuthData.toTemporaryPasswordRequest() =
    TemporaryPasswordRequest(
        email = email,
        id = id
    )
