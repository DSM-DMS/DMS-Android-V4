package com.dsm.dms.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(primaryKeys = ["classNum", "time"])
data class MapEntity(
    var classNum: Int,
    var time: Int,
    var map: List<List<Any>>
)
