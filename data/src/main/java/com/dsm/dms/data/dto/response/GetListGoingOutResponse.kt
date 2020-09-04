package com.dsm.dms.data.dto.response

import com.dsm.dms.data.entity.GoingOutInfoData


data class GetListGoingOutResponse(
    var goingOut: List<GoingOutInfoData>
)
