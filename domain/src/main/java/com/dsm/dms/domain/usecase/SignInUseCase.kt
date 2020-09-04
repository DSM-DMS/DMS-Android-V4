package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.Auth
import com.dsm.dms.domain.service.AccountService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import com.dsm.dms.domain.base.Result


class SignInUseCase(
    private val service: AccountService,
    composite: CompositeDisposable
): UseCase<Auth, Result<Unit>>(composite) {

    override fun create(auth: Auth): Single<Result<Unit>> =
        service.signIn(auth)

}
