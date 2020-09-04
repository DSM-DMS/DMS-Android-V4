package com.dsm.dms.domain.entity

import com.dsm.dms.domain.entity.enums.StayInfo

data class ApplyInfo(
    var extension: List<ExtensionInfo>?,
    var stay: StayInfo?,
    var goingOut: List<GoingOutInfo>?
)
