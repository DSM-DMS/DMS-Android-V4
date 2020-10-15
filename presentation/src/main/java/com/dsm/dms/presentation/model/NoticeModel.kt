package com.dsm.dms.presentation.model

import com.dsm.dms.domain.entity.Notice


data class NoticeModel(
    val id: Int,
    val title: String,
    val content: String,
    val viewCount: String,
    val date: String,
    val isViewed: Boolean
)

fun NoticeModel.toEntity() =
    Notice(
        id = id,
        date = date,
        title = title,
        content = content,
        views = viewCount.toInt(),
        isViewed = isViewed
    )

fun Notice.toModel() =
    NoticeModel(
        id = id,
        date = date,
        title = title,
        content = content,
        viewCount = views.toString(),
        isViewed = isViewed
    )
