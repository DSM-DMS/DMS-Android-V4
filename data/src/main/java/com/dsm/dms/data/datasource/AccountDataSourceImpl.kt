package com.dsm.dms.data.datasource

import com.dsm.dms.data.entity.*
import com.dsm.dms.data.local.pref.LocalStorage
import com.dsm.dms.data.remote.AccountApi
import io.reactivex.Completable
import io.reactivex.Single

class AccountDataSourceImpl(
    private val accountApi: AccountApi,
    private val localStorage: LocalStorage
): AccountDataSource {

    override fun signIn(authData: AuthData): Single<TokenData>
            = accountApi.signIn(authData.toSignInRequest())

    override fun signUp(authData: AuthData): Completable
            = accountApi.signUp(authData.toSignUpRequest())

    override fun changePassword(changePasswordData: ChangePasswordData): Completable
            = accountApi.changePassword(changePasswordData)

    override fun temporaryPassword(authData: AuthData): Completable
            = accountApi.requestTemporaryPassword(authData.toTemporaryPasswordRequest())

    override fun saveToken(token: String, isAccess: Boolean)
            = localStorage.saveToken(token, isAccess)

    override fun getToken(isAccess: Boolean): Single<String>
            = Single.fromCallable {
        localStorage.getToken(isAccess)
    }

}