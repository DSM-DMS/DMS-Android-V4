package com.dsm.dms.data.entity

import com.dsm.dms.domain.entity.ApplyInfo
import com.dsm.dms.domain.entity.enums.StayInfo


data class ApplyInfoData(
    var extension: List<ExtensionInfoData>?,
    var stay: StayInfo?,
    var goingOut: List<GoingOutInfoData>?
)

fun ApplyInfoData.toEntity() =
    ApplyInfo(
        extension = extension?.map { it.toEntity() },
        stay = stay,
        goingOut = goingOut?.map { it.toEntity() }
    )

fun ApplyInfo.toDataEntity() =
    ApplyInfoData(
        extension = extension?.map { it.toDataEntity() },
        stay = stay,
        goingOut = goingOut?.map { it.toDataEntity() }
    )
