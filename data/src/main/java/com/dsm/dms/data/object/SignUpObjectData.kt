package com.dsm.dms.data.`object`

import com.dsm.dms.data.entity.AuthData
import com.dsm.dms.data.entity.toDataEntity
import com.dsm.dms.data.entity.toEntity
import com.dsm.dms.domain.`object`.SignUpObject

data class SignUpObjectData(
    var authData: AuthData,
    var verificationKeyData: VerificationKeyData
)

fun SignUpObjectData.toObject() =
    SignUpObject(
        auth = authData.toEntity(),
        verificationKey = verificationKeyData.toEntity()
    )

fun SignUpObject.toDataObject() =
    SignUpObjectData(
        authData = auth.toDataEntity(),
        verificationKeyData = verificationKey.toDataEntity()
    )
