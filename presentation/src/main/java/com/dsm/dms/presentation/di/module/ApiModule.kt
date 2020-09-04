package com.dsm.dms.presentation.di.module

import com.dsm.dms.data.remote.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class ApiModule {

    companion object {
        private val baseUrl = "https://dev-api.dsm-dms.com/"
        private val mealUrl = "${baseUrl}meal/"
        private val accountUrl = "${baseUrl}account/"
        private val applyUrl = "${baseUrl}apply/"
        private val infoUrl = "${baseUrl}info/"
        private val noticeUrl = "${baseUrl}notice/"
    }

    @Provides
    @Singleton
    fun provideMealApi(retrofit: Retrofit.Builder): MealApi =
        retrofit.baseUrl(mealUrl)
            .build()
            .create(MealApi::class.java)

    @Provides
    @Singleton
    fun provideAccountApi(retrofit: Retrofit.Builder): AccountApi =
        retrofit.baseUrl(accountUrl)
            .build()
            .create(AccountApi::class.java)

    @Provides
    @Singleton
    fun provideApplyApi(retrofit: Retrofit.Builder): ApplyApi =
        retrofit.baseUrl(applyUrl)
            .build()
            .create(ApplyApi::class.java)

    @Provides
    @Singleton
    fun provideInfoApi(retrofit: Retrofit.Builder): InfoApi =
        retrofit.baseUrl(infoUrl)
            .build()
            .create(InfoApi::class.java)

    @Provides
    @Singleton
    fun provideNoticeApi(retrofit: Retrofit.Builder): NoticeApi =
        retrofit.baseUrl(noticeUrl)
            .build()
            .create(NoticeApi::class.java)

}
