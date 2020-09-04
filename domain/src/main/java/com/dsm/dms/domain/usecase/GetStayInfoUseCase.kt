package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.enums.StayInfo
import com.dsm.dms.domain.service.StayService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class GetStayInfoUseCase(
    private val service: StayService,
    composite: CompositeDisposable
): UseCase<Unit, Result<StayInfo>>(composite) {

    override fun create(data: Unit): Single<Result<StayInfo>> =
        service.getStayInfo()

}
