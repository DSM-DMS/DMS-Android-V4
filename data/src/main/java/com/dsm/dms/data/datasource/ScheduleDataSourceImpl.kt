package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.response.GetListScheduleResponse
import com.dsm.dms.data.local.database.dao.ScheduleDao
import com.dsm.dms.data.local.database.entity.ScheduleEntity
import com.dsm.dms.data.remote.InfoApi
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


class ScheduleDataSourceImpl(
    private val api: InfoApi,
    private val scheduleDao: ScheduleDao
): ScheduleDataSource {

    override fun getRemoteSchedule(date: String): Single<GetListScheduleResponse> =
        api.getSchedule(date)

    override fun getLocalSchedule(date: String): List<ScheduleEntity>? =
        scheduleDao.getAllScheduleData()

    override fun saveLocalSchedule(vararg scheduleEntity: ScheduleEntity) =
        scheduleDao.saveScheduleData(*scheduleEntity)

    override fun deleteLocalSchedule(id: Int) =
        scheduleDao.deleteScheduleData(id)
}
