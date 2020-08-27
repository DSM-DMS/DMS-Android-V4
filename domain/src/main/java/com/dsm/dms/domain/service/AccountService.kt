package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Auth
import com.dsm.dms.domain.entity.ChangePassword
import io.reactivex.Completable
import io.reactivex.Single

interface AccountService {

    fun signIn(auth: Auth): Single<Result<Unit>>

    fun signUp(auth: Auth): Single<Result<Unit>>

    fun changePassword(changePassword: ChangePassword): Single<Result<Unit>>

    fun temporaryPassword(auth: Auth): Single<Result<Unit>>

}