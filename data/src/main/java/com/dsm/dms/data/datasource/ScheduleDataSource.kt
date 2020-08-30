package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.response.GetListScheduleResponse
import com.dsm.dms.data.entity.ScheduleData
import com.dsm.dms.data.local.database.entity.ScheduleEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single


interface ScheduleDataSource {

    fun getRemoteSchedule(date: String): Single<GetListScheduleResponse>

    fun getLocalSchedule(date: String): List<ScheduleEntity>?

    fun saveLocalSchedule(vararg scheduleEntity: ScheduleEntity)

    fun deleteLocalSchedule(id: Int)

}
