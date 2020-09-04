package com.dsm.dms.domain.`object`

import com.dsm.dms.domain.entity.Auth

data class SignUpObject(
    var auth: Auth,
    var verificationKey: VerificationKey
)
