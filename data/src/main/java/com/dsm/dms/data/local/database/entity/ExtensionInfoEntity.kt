package com.dsm.dms.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ExtensionInfoEntity(
    @PrimaryKey
    var time: Int,
    var classNumber: Int,
    var seatNumber: Int
)
