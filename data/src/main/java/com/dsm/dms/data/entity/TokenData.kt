package com.dsm.dms.data.entity

import com.dsm.dms.domain.entity.Token

data class TokenData(
    var accessToken: String,
    var refreshToken: String
)

fun Token.toDataToken() =
    TokenData(
        accessToken = accessToken,
        refreshToken = refreshToken
    )

fun TokenData.toEntity() =
    Token(
        accessToken = accessToken,
        refreshToken = refreshToken
    )
