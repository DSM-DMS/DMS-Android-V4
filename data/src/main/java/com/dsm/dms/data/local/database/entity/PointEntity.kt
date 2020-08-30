package com.dsm.dms.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PointEntity(
    @PrimaryKey
    var name: String,
    var point: Int
)
