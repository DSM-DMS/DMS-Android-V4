package com.dsm.dms.data.`object`

import com.dsm.dms.domain.`object`.Room
import com.dsm.dms.domain.entity.enums.ClassNum


data class RoomData(
    var time: Int,
    var classNum: ClassNum
)

fun Room.toDataObject() =
    RoomData(
        time = time,
        classNum = classNum
    )

fun RoomData.toObject() =
    Room(
        time = time,
        classNum = classNum
    )
