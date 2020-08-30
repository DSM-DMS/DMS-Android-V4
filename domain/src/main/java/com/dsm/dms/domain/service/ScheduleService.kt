package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Schedule
import io.reactivex.Single


interface ScheduleService {

    fun getSchedule(date: String): Single<Result<List<Schedule>>>

}
