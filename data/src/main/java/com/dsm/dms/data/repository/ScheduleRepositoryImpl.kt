package com.dsm.dms.data.repository

import com.dsm.dms.data.datasource.ScheduleDataSource
import com.dsm.dms.data.entity.toDataEntity
import com.dsm.dms.data.entity.toDbEntity
import com.dsm.dms.data.entity.toEntity
import com.dsm.dms.domain.entity.Schedule
import com.dsm.dms.domain.repository.ScheduleRepository
import io.reactivex.Single


class ScheduleRepositoryImpl(
    private val dataSource: ScheduleDataSource
): ScheduleRepository {

    override fun getRemoteSchedule(date: String): Single<List<Schedule>> =
        dataSource.getRemoteSchedule(date).map { response ->
            response.schedule.map { data ->
                data.toEntity()
            }
        }

    override fun getLocalSchedule(date: String): List<Schedule>? =
        dataSource.getLocalSchedule(date)?.map { it.toDataEntity().toEntity() }

    override fun saveLocalSchedule(vararg schedule: Schedule) =
        dataSource.saveLocalSchedule(
            *schedule.map {
                it.toDataEntity().toDbEntity()
            }.toTypedArray()
        )

    override fun deleteLocalSchedule(id: Int) =
        dataSource.deleteLocalSchedule(id)

}
