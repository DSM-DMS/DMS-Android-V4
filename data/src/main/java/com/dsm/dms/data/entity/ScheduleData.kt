package com.dsm.dms.data.entity

import com.dsm.dms.data.local.database.entity.ScheduleEntity
import com.dsm.dms.domain.entity.Schedule


data class ScheduleData(
    var id: Int,
    var name: String,
    var time: String,
    var place: String
)

fun ScheduleData.toEntity() =
    Schedule(
        id = id,
        name = name,
        time = time,
        place = place
    )

fun Schedule.toDataEntity() =
    ScheduleData(
        id = id,
        name = name,
        time = time,
        place = place
    )

fun ScheduleData.toDbEntity() =
    ScheduleEntity(
        id = id,
        name = name,
        time = time,
        place = place
    )

fun ScheduleEntity.toDataEntity() =
    ScheduleData(
        id = id,
        name = name,
        time = time,
        place = place
    )
