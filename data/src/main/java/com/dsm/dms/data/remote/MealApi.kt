package com.dsm.dms.data.remote

import com.dsm.dms.data.entity.MealData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface MealApi {

    @GET("{date}")
    fun getMeal(@Path("date") date: String): Single<MealData>

}
