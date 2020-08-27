package com.dsm.dms.data.entity

import androidx.room.PrimaryKey
import com.dsm.dms.data.local.database.entity.GoingOutInfoEntity
import com.dsm.dms.domain.entity.GoingOutInfo
import com.dsm.dms.domain.entity.enums.GoingOutType


data class GoingOutInfoData(
    @PrimaryKey
    var id: Int,
    var type: GoingOutType,
    var date: String,
    var place: String
)

fun GoingOutInfoData.toEntity() =
    GoingOutInfo(
        id = id,
        type = type,
        date = date,
        place = place
    )

fun GoingOutInfo.toDataEntity() =
    GoingOutInfoData(
        id = id,
        type = type,
        date = date,
        place = place
    )

fun GoingOutInfoData.toDbEntity() =
    GoingOutInfoEntity(
        id = id,
        type = type,
        date = date,
        place = place
    )

fun GoingOutInfoEntity.toDataEntity() =
    GoingOutInfoData(
        id = id,
        type = type,
        date = date,
        place = place
    )
