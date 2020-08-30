package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.Auth
import com.dsm.dms.domain.entity.ChangePassword
import com.dsm.dms.domain.entity.Token
import io.reactivex.Completable
import io.reactivex.Single

interface AccountRepository {

    fun signIn(auth: Auth): Single<Token>

    fun signUp(auth: Auth): Completable

    fun changePassword(changePassword: ChangePassword): Completable

    fun temporaryPassword(auth: Auth): Completable

    fun saveToken(token: String, isAccess: Boolean)

    fun getToken(isAccess: Boolean): Single<String>

}