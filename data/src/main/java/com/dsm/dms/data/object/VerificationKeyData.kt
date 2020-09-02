package com.dsm.dms.data.`object`

import com.dsm.dms.domain.`object`.VerificationKey

data class VerificationKeyData(
    var verificationKey: String
)

fun VerificationKeyData.toEntity() =
    VerificationKey(
        verificationKey = verificationKey
    )

fun VerificationKey.toDataEntity() =
    VerificationKeyData(
        verificationKey = verificationKey
    )
