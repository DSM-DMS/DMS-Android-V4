package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.request.VerifyCertificationCodeRequest
import com.dsm.dms.data.entity.AuthData
import com.dsm.dms.data.`object`.ChangePasswordData
import com.dsm.dms.data.`object`.SignUpObjectData
import com.dsm.dms.data.`object`.VerificationKeyData
import com.dsm.dms.data.entity.TokenData
import io.reactivex.Completable
import io.reactivex.Single

interface AccountDataSource {

    fun signIn(authData: AuthData): Single<TokenData>

    fun signUp(signUpObjectData: SignUpObjectData): Completable

    fun changePassword(changePasswordData: ChangePasswordData): Completable

    fun temporaryPassword(authData: AuthData): Completable

    fun saveToken(token: String, isAccess: Boolean)

    fun getToken(isAccess: Boolean): Single<String>

    fun verifyCertificationCode(certificationCode: String): Single<VerificationKeyData>

}
