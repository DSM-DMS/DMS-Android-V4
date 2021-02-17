package com.dsm.dms.presentation.model

import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.entity.enums.ClassNum


data class ExtensionInfoModel(
    var classNum: ClassNum,
    var seatNum: Int,
    var time: Int
)

fun ExtensionInfoModel.toEntity() =
    ExtensionInfo(
        classNum = classNum,
        seatNum = seatNum,
        time = time
    )

fun ExtensionInfo.toModel() =
    ExtensionInfoModel(
        classNum = classNum,
        seatNum = seatNum,
        time = time
    )
