package com.dsm.dms.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dsm.dms.domain.entity.enums.ClassNum


@Entity
data class ExtensionInfoEntity(
    @PrimaryKey
    var time: Int,
    var classNum: ClassNum,
    var seatNum: Int
)
