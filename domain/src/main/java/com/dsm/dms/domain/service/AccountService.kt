package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Auth
import com.dsm.dms.domain.`object`.ChangePassword
import com.dsm.dms.domain.`object`.SignUpObject
import com.dsm.dms.domain.`object`.VerificationKey
import io.reactivex.Single

interface AccountService {

    fun signIn(auth: Auth): Single<Result<Unit>>

    fun signUp(signUpObject: SignUpObject): Single<Result<Unit>>

    fun changePassword(changePassword: ChangePassword): Single<Result<Unit>>

    fun temporaryPassword(auth: Auth): Single<Result<Unit>>

    fun verifyCertificationCode(certificationCode: String): Single<Result<VerificationKey>>

}