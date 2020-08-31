package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.service.GoingOutService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class CancelGoingOutUseCase(
    private val service: GoingOutService,
    composite: CompositeDisposable
): UseCase<Int, Result<Unit>>(composite) {

    override fun create(id: Int): Single<Result<Unit>> =
        service.deleteGoingOutInfo(id)

}
