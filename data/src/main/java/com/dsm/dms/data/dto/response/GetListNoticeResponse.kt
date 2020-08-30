package com.dsm.dms.data.dto.response

import com.dsm.dms.data.entity.NoticeData


data class GetListNoticeResponse(
    val notice: List<NoticeData>
)
