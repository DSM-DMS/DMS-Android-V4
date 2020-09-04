package com.dsm.dms.data.datasource

import com.dsm.dms.data.`object`.ChangePasswordData
import com.dsm.dms.data.`object`.SignUpObjectData
import com.dsm.dms.data.`object`.VerificationKeyData
import com.dsm.dms.data.dto.request.VerifyCertificationCodeRequest
import com.dsm.dms.data.entity.*
import com.dsm.dms.data.local.pref.LocalStorage
import com.dsm.dms.data.remote.AccountApi
import io.reactivex.Completable
import io.reactivex.Single

class AccountDataSourceImpl(
    private val api: AccountApi,
    private val localStorage: LocalStorage
): AccountDataSource {

    override fun signIn(authData: AuthData): Single<TokenData> =
        api.signIn(authData.toSignInRequest())

    override fun signUp(signUpObjectData: SignUpObjectData): Completable =
        api.signUp(
            signUpObjectData.verificationKeyData.verificationKey,
            signUpObjectData.authData.toSignUpRequest()
        )

    override fun changePassword(changePasswordData: ChangePasswordData): Completable =
        api.changePassword(changePasswordData)

    override fun temporaryPassword(authData: AuthData): Completable =
        api.requestTemporaryPassword(authData.toTemporaryPasswordRequest())

    override fun saveToken(token: String, isAccess: Boolean) =
        localStorage.saveToken(token, isAccess)

    override fun getToken(isAccess: Boolean): Single<String> =
        Single.fromCallable {
            localStorage.getToken(isAccess)
        }

    override fun verifyCertificationCode(certificationCode: String): Single<VerificationKeyData> =
        api.verifyCertificationCode(
            VerifyCertificationCodeRequest(certificationCode)
        )

}