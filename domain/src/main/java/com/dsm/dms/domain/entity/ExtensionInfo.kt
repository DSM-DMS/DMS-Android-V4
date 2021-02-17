package com.dsm.dms.domain.entity

import com.dsm.dms.domain.entity.enums.ClassNum

data class ExtensionInfo(
    var classNum: ClassNum,
    var seatNum: Int,
    var time: Int
)
