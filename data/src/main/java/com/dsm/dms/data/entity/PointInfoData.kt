package com.dsm.dms.data.entity

import com.dsm.dms.domain.entity.PointInfo


data class PointInfoData(
    var goodPoint: Int,
    var badPoint: Int,
    var penaltyLevel: Int
)

fun PointInfoData.toEntity() =
    PointInfo(
        goodPoint = goodPoint,
        badPoint = badPoint,
        penaltyLevel = penaltyLevel
    )

fun PointInfo.toDataEntity() =
    PointInfoData(
        goodPoint = goodPoint,
        badPoint = badPoint,
        penaltyLevel = penaltyLevel
    )
