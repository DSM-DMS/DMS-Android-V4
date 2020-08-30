package com.dsm.dms.domain.entity

data class Notice(
    var id: Int,
    var date: String,
    var title: String,
    var content: String,
    var views: Int
)
