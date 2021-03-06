package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.GoingOutInfo
import com.dsm.dms.domain.service.GoingOutService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class ApplyGoingOutUseCase(
    private val service: GoingOutService,
    composite: CompositeDisposable
): UseCase<GoingOutInfo, Result<Unit>>(composite) {

    override fun create(goingOutInfo: GoingOutInfo): Single<Result<Unit>> =
        service.applyGoingOut(goingOutInfo)

}
