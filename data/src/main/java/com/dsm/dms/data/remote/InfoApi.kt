package com.dsm.dms.data.remote

import com.dsm.dms.data.dto.response.GetListScheduleResponse
import com.dsm.dms.data.entity.UserData
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface InfoApi {

    @GET("schedule/{date}")
    fun getSchedule(@Path("date") date: String): Single<GetListScheduleResponse>

    @GET("{uuid}")
    fun getMyData(@Path("uuid") uuid: String): Single<UserData>

}
