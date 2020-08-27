package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Auth
import com.dsm.dms.domain.entity.ChangePassword
import com.dsm.dms.domain.repository.AccountRepository
import com.dsm.dms.domain.toResult
import com.dsm.dms.domain.toSingleResult
import io.reactivex.Single

class AccountServiceImpl(
    private val repository: AccountRepository,
    private val handler: ErrorHandler
): AccountService {

    override fun signIn(auth: Auth): Single<Result<Unit>> =
        repository.signIn(auth)
            .toResult(handler = handler)
            .map {
                when(it) {
                    is Result.Success -> {
                        repository.saveToken(it.data.accessToken, true)
                        repository.saveToken(it.data.refreshToken, false)
                        Result.Success(Unit)
                    }
                    is Result.Error -> {
                        Result.Error(Unit, it.message)
                    }
                }
            }

    override fun signUp(auth: Auth): Single<Result<Unit>> =
        repository.signUp(auth)
            .toSingleResult(handler)

    override fun changePassword(changePassword: ChangePassword): Single<Result<Unit>> =
        repository.changePassword(changePassword)
            .toSingleResult(handler)

    override fun temporaryPassword(auth: Auth): Single<Result<Unit>> =
        repository.temporaryPassword(auth)
            .toSingleResult(handler)

}
