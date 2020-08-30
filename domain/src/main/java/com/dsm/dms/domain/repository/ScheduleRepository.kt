package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.Schedule
import io.reactivex.Single


interface ScheduleRepository {

    fun getRemoteSchedule(date: String): Single<List<Schedule>>

    fun getLocalSchedule(date: String): List<Schedule>?

    fun saveLocalSchedule(vararg schedule: Schedule)

    fun deleteLocalSchedule(id: Int)

}
