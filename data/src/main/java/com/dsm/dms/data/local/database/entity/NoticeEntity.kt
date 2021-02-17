package com.dsm.dms.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NoticeEntity(
    @PrimaryKey
    var id: Int,
    var date: String,
    var title: String,
    var content: String,
    var views: Int,
    var isViewed: Boolean
)
