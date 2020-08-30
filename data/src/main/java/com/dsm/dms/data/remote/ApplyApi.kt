package com.dsm.dms.data.remote

import com.dsm.dms.data.dto.response.GetListGoingOutResponse
import com.dsm.dms.data.entity.ExtensionInfoData
import com.dsm.dms.data.entity.GoingOutInfoData
import com.dsm.dms.data.entity.MapData
import com.dsm.dms.domain.entity.enums.StayInfo
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.*


interface ApplyApi {

    @GET("extension/map/{time}/{classNum}")
    fun getExtensionStudyMap(
        @Path("time") time: Int,
        @Path("classNum") classNum: Int): Single<MapData>

    @DELETE("extension/{time}")
    fun deleteExtensionStudy(@Path("time") time: Int): Completable

    @GET("extension/{time}")
    fun getExtensionStudy(@Path("time") time: Int): Single<ExtensionInfoData>

    @POST("extension")
    fun postExtensionStudy(@Body body: ExtensionInfoData): Completable

    @GET("goingout")
    fun getGoingOut(): Single<GetListGoingOutResponse>

    @POST("goingout")
    fun postGoingOut(@Body body: GoingOutInfoData): Completable

    @DELETE("goingout/{id}")
    fun deleteGoingOut(@Path("id") id: Int): Completable

    @PATCH("goingout/{id}")
    fun patchGoingOut(@Path("id") id: Int, @Body body: GoingOutInfoData): Completable

    @GET("stay")
    fun getStay(): Single<StayInfo>

    @POST("stay")
    fun postStay(@Body body: StayInfo): Completable

}
