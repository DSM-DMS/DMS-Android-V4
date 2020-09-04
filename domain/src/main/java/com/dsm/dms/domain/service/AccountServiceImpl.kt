package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Auth
import com.dsm.dms.domain.`object`.ChangePassword
import com.dsm.dms.domain.`object`.SignUpObject
import com.dsm.dms.domain.`object`.VerificationKey
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
            .map {
                repository.saveToken(it.accessToken, true)
                repository.saveToken(it.refreshToken, false)
            }
            .toResult(handler)

    override fun signUp(signUpObject: SignUpObject): Single<Result<Unit>> =
        repository.signUp(signUpObject)
            .toSingleResult(handler)

    override fun changePassword(changePassword: ChangePassword): Single<Result<Unit>> =
        repository.changePassword(changePassword)
            .toSingleResult(handler)

    override fun temporaryPassword(auth: Auth): Single<Result<Unit>> =
        repository.temporaryPassword(auth)
            .toSingleResult(handler)

    override fun verifyCertificationCode(certificationCode: String): Single<Result<VerificationKey>> =
        repository.verifyCertificationCode(certificationCode)
            .toResult(handler)

}
