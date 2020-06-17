package com.dsm.dms.presentation.model

data class NoticeModel(
    val title: String,
    val content: String,
    val viewCount: String,
    val date: String,
    val isViewed: Boolean
)
