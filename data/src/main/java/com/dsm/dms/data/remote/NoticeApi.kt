package com.dsm.dms.data.remote

import com.dsm.dms.data.dto.response.GetListNoticeResponse
import com.dsm.dms.data.dto.response.GetListPointNoticeResponse
import io.reactivex.Single
import retrofit2.http.GET


interface NoticeApi {

    @GET
    fun getNotice(): Single<GetListNoticeResponse>

    @GET("point")
    fun getPointNotice(): Single<GetListPointNoticeResponse>

}
