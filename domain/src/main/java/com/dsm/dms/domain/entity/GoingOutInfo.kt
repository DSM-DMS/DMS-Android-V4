package com.dsm.dms.domain.entity

import com.dsm.dms.domain.entity.enums.GoingOutType

data class GoingOutInfo(
    var id: Int,
    var type: GoingOutType,
    var date: String,
    var place: String
)
