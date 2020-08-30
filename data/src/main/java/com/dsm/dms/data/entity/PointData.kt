package com.dsm.dms.data.entity

import com.dsm.dms.data.local.database.entity.PointEntity
import com.dsm.dms.domain.entity.Point


data class PointData(
    var name: String,
    var point: Int
)

fun Point.toDataEntity() =
    PointData(
        name = name,
        point = point
    )

fun PointData.toEntity() =
    Point(
        name = name,
        point = point
    )

fun PointData.toDbEntity() =
    PointEntity(
        name = name,
        point = point
    )

fun PointEntity.toDataEntity() =
    PointData(
        name = name,
        point = point
    )
