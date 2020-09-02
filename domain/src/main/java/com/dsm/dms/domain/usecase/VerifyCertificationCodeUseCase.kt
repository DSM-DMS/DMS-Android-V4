package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.`object`.VerificationKey
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.service.AccountService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class VerifyCertificationCodeUseCase(
    private val service: AccountService,
    composite: CompositeDisposable
): UseCase<String, Result<VerificationKey>>(composite) {

    override fun create(certificationCode: String): Single<Result<VerificationKey>> =
        service.verifyCertificationCode(certificationCode)

}
