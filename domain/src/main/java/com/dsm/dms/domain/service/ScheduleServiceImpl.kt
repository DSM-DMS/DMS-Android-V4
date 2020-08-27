package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Schedule
import com.dsm.dms.domain.repository.ScheduleRepository
import com.dsm.dms.domain.toResult
import io.reactivex.Single


class ScheduleServiceImpl(
    private val repository: ScheduleRepository,
    private val handler: ErrorHandler
): ScheduleService {

    override fun getSchedule(date: String): Single<Result<List<Schedule>>> =
        repository.getRemoteSchedule(date)
            .toResult(
                handler = handler,
                localData = repository.getLocalSchedule(date),
                saveLocalFun = { T -> repository.saveLocalSchedule(*T.toTypedArray()) }
            )

}
