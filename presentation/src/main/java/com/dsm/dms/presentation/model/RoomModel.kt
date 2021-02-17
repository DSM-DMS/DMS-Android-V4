package com.dsm.dms.presentation.model

import com.dsm.dms.domain.`object`.Room
import com.dsm.dms.domain.entity.enums.ClassNum


data class RoomModel(
    var time: Int,
    var classNum: ClassNum
)

fun Room.toModel() =
    RoomModel(
        time = time,
        classNum = classNum
    )

fun RoomModel.toObject() =
    Room(
        time = time,
        classNum = classNum
    )
