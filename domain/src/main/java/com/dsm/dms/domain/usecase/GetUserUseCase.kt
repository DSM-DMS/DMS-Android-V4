package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.User
import com.dsm.dms.domain.service.UserService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class GetUserUseCase(
    private val service: UserService,
    composite: CompositeDisposable
): UseCase<String, Result<User>>(composite) {

    override fun create(uuid: String): Single<Result<User>> =
        service.getUser(uuid)

}
