package com.dsm.dms.domain.entity

data class User(
    var name: String,
    var studentNumber: Int,
    var point: PointInfo,
    var apply: ApplyInfo
)
