package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.Auth
import com.dsm.dms.domain.`object`.ChangePassword
import com.dsm.dms.domain.`object`.SignUpObject
import com.dsm.dms.domain.`object`.VerificationKey
import com.dsm.dms.domain.entity.Token
import io.reactivex.Completable
import io.reactivex.Single

interface AccountRepository {

    fun signIn(auth: Auth): Single<Token>

    fun signUp(signUpObject: SignUpObject): Completable

    fun changePassword(changePassword: ChangePassword): Completable

    fun temporaryPassword(auth: Auth): Completable

    fun saveToken(token: String, isAccess: Boolean)

    fun getToken(isAccess: Boolean): Single<String>

    fun verifyCertificationCode(certificationCode: String): Single<VerificationKey>

}