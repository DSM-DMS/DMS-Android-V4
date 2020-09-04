package com.dsm.dms.presentation.model

import com.dsm.dms.domain.`object`.SignUpObject


class SignUpModel(
    var authModel: AuthModel,
    var verificationCodeModel: VerificationKeyModel
)

fun SignUpModel.toObject() =
    SignUpObject(
        auth = authModel.toEntity(),
        verificationKey = verificationCodeModel.toObject()
    )

fun SignUpObject.toOModel() =
    SignUpModel(
        authModel = auth.toModel(),
        verificationCodeModel = verificationKey.toModel()
    )
