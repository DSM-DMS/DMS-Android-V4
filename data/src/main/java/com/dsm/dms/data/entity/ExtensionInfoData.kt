package com.dsm.dms.data.entity

import com.dsm.dms.data.local.database.entity.ExtensionInfoEntity
import com.dsm.dms.domain.entity.ExtensionInfo


data class ExtensionInfoData(
    var time: Int,
    var classNumber: Int,
    var seatNumber: Int
)

fun ExtensionInfoData.toEntity() =
    ExtensionInfo(
        classNumber = classNumber,
        seatNumber = seatNumber,
        time = time
    )

fun ExtensionInfo.toDataEntity() =
    ExtensionInfoData(
        classNumber = classNumber,
        seatNumber = seatNumber,
        time = time
    )

fun ExtensionInfoData.toDbEntity() =
    ExtensionInfoEntity(
        classNumber = classNumber,
        seatNumber = seatNumber,
        time = time
    )

fun ExtensionInfoEntity.toDataEntity() =
    ExtensionInfoData(
        classNumber = classNumber,
        seatNumber = seatNumber,
        time = time
    )
