package com.dsm.dms.data.dto.response

import com.dsm.dms.data.entity.PointData


data class GetListPointNoticeResponse(
    var point: List<PointData>
)
