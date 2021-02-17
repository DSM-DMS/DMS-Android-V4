package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.`object`.ChangePassword
import com.dsm.dms.domain.service.AccountService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class ChangePasswordUseCase(
    private val service: AccountService,
    composite: CompositeDisposable
): UseCase<ChangePassword, Result<Unit>>(composite) {

    override fun create(changePassword: ChangePassword): Single<Result<Unit>> =
        service.changePassword(changePassword)

}
