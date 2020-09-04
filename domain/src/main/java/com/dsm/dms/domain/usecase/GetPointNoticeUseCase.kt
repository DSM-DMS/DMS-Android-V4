package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.Point
import com.dsm.dms.domain.service.PointNoticeService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class GetPointNoticeUseCase(
    private val service: PointNoticeService,
    composite: CompositeDisposable
): UseCase<Unit, Result<List<Point>>>(composite) {

    override fun create(data: Unit): Single<Result<List<Point>>> =
        service.getPointNotice()

}
