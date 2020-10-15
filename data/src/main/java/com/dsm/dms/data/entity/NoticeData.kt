package com.dsm.dms.data.entity

import com.dsm.dms.data.local.database.entity.NoticeEntity
import com.dsm.dms.domain.entity.Notice


data class NoticeData(
    var id: Int,
    var date: String,
    var title: String,
    var content: String,
    var views: Int,
    var isViewed: Boolean
)

fun NoticeData.toEntity() =
    Notice(
        id = id,
        date = date,
        title = title,
        content = content,
        views = views,
        isViewed = isViewed
    )

fun Notice.toDataEntity() =
    NoticeData(
        id = id,
        date = date,
        title = title,
        content = content,
        views = views,
        isViewed = isViewed
    )

fun NoticeData.toDbEntity() =
    NoticeEntity(
        id = id,
        date = date,
        title = title,
        content = content,
        views = views,
        isViewed = isViewed
    )

fun NoticeEntity.toDataEntity() =
    NoticeData(
        id = id,
        date = date,
        title = title,
        content = content,
        views = views,
        isViewed = isViewed
    )
