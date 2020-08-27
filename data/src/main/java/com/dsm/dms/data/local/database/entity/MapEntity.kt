package com.dsm.dms.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MapEntity(
    @PrimaryKey
    var id: String,
    var classNum: Int,
    var time: Int,
    var map: List<List<Any>>
)
