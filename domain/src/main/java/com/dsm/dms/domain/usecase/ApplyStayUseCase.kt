package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.enums.StayInfo
import com.dsm.dms.domain.service.StayService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import com.dsm.dms.domain.base.Result

class ApplyStayUseCase(
    private val service: StayService,
    composite: CompositeDisposable
): UseCase<StayInfo, Result<Unit>>(composite) {

    override fun create(stayInfo: StayInfo): Single<Result<Unit>> =
        service.postStayInfo(stayInfo)

}
