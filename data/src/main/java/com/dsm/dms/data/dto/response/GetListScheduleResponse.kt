package com.dsm.dms.data.dto.response

import com.dsm.dms.data.entity.ScheduleData

data class GetListScheduleResponse(
    var schedule: List<ScheduleData>
)
