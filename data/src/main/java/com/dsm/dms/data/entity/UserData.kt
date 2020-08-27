package com.dsm.dms.data.entity

import com.dsm.dms.data.local.database.entity.UserEntity
import com.dsm.dms.domain.entity.User


data class UserData(
    var studentNumber: Int,
    var name: String,
    var point: PointInfoData,
    var apply: ApplyInfoData
)

fun UserData.toEntity() =
    User(
        name = name,
        studentNumber = studentNumber,
        point = point.toEntity(),
        apply = apply.toEntity()
    )

fun User.toDataEntity() =
    UserData(
        name = name,
        studentNumber = studentNumber,
        point = point.toDataEntity(),
        apply = apply.toDataEntity()
    )

fun UserData.toDbEntity() =
    UserEntity(
        name = name,
        studentNumber = studentNumber,
        point = point,
        stayInfo = apply.stay
    )

fun UserEntity.toDataEntity() =
    UserData(
        name = name,
        studentNumber = studentNumber,
        point = point,
        apply = ApplyInfoData(
            extension = null,
            stay = stayInfo,
            goingOut = null
        )
    )
