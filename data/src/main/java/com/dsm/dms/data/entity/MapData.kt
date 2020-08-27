package com.dsm.dms.data.entity

import com.dsm.dms.data.local.database.entity.MapEntity
import com.dsm.dms.domain.entity.Map


data class MapData(
    var id: String,
    var classNum: Int,
    var time: Int,
    var map: List<List<Any>>
)

fun MapData.toEntity() =
    Map(
        id = id,
        classNum = classNum,
        time = time,
        map = map
    )

fun Map.toDataEntity() =
    MapData(
        id = id,
        classNum = classNum,
        time = time,
        map = map
    )

fun MapData.toDbEntity() =
    MapEntity(
        id = id,
        classNum = classNum,
        time = time,
        map = map
    )

fun MapEntity.toDataEntity() =
    MapData(
        id = id,
        classNum = classNum,
        time = time,
        map = map
    )
