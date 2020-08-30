package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.GoingOutInfo
import com.dsm.dms.domain.service.GoingOutService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class GetGoingOutInfoUseCase(
    private val service: GoingOutService,
    composite: CompositeDisposable
): UseCase<Unit, Result<List<GoingOutInfo>>>(composite) {

    override fun create(data: Unit): Single<Result<List<GoingOutInfo>>> =
        service.getGoingOutInfo()

}
