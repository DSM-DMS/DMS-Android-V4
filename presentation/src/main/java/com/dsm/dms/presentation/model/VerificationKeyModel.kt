package com.dsm.dms.presentation.model

import com.dsm.dms.domain.`object`.VerificationKey

data class VerificationKeyModel(
    var verificationKey: String
)

fun VerificationKeyModel.toObject() =
    VerificationKey(
        verificationKey
    )

fun VerificationKey.toModel() =
    VerificationKeyModel(
        verificationKey
    )
