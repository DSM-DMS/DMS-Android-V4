package com.dsm.dms.data.entity

import com.dsm.dms.data.local.database.entity.ExtensionInfoEntity
import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.entity.enums.ClassNum


data class ExtensionInfoData(
    var time: Int,
    var classNum: ClassNum,
    var seatNum: Int
)

fun ExtensionInfoData.toEntity() =
    ExtensionInfo(
        classNum = classNum,
        seatNum = seatNum,
        time = time
    )

fun ExtensionInfo.toDataEntity() =
    ExtensionInfoData(
        classNum = classNum,
        seatNum = seatNum,
        time = time
    )

fun ExtensionInfoData.toDbEntity() =
    ExtensionInfoEntity(
        classNum = classNum,
        seatNum = seatNum,
        time = time
    )

fun ExtensionInfoEntity.toDataEntity() =
    ExtensionInfoData(
        classNum = classNum,
        seatNum = seatNum,
        time = time
    )
