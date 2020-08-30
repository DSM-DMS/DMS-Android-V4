package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.request.SignInRequest
import com.dsm.dms.data.dto.request.SignUpRequest
import com.dsm.dms.data.dto.request.TemporaryPasswordRequest
import com.dsm.dms.data.entity.AuthData
import com.dsm.dms.data.entity.ChangePasswordData
import com.dsm.dms.data.entity.TokenData
import io.reactivex.Completable
import io.reactivex.Single

interface AccountDataSource {

    fun signIn(authData: AuthData): Single<TokenData>

    fun signUp(authData: AuthData): Completable

    fun changePassword(changePasswordData: ChangePasswordData): Completable

    fun temporaryPassword(authData: AuthData): Completable

    fun saveToken(token: String, isAccess: Boolean)

    fun getToken(isAccess: Boolean): Single<String>

}
