package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.Schedule
import com.dsm.dms.domain.service.ScheduleService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class GetScheduleUseCase(
    private val service: ScheduleService,
    composite: CompositeDisposable
): UseCase<String, Result<List<Schedule>>>(composite) {

    override fun create(date: String): Single<Result<List<Schedule>>> =
        service.getSchedule(date)

}
