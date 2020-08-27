package com.dsm.dms.presentation.di.module

import com.dsm.dms.data.remote.MealApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class ApiModule {

    companion object {
        private val mealUrl = "https://dev-api.dsm-dms.com/meal/"
    }

    @Provides
    @Singleton
    fun provideMealApi(retrofit: Retrofit.Builder): MealApi =
        retrofit.baseUrl(mealUrl)
            .build()
            .create(MealApi::class.java)

}
