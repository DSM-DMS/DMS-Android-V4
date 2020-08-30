package com.dsm.dms.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ScheduleEntity(
    @PrimaryKey
    var id: Int,
    var name: String,
    var time: String,
    var place: String
)
