package com.dsm.dms.presentation.di.module

import com.dsm.dms.data.local.database.Database
import com.dsm.dms.data.local.database.dao.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideUserDao(
        database: Database
    ): UserDao =
        database.userDao

    @Provides
    @Singleton
    fun provideExtensionInfoDao(
        database: Database
    ): ExtensionInfoDao =
        database.extensionInfoDao

    @Provides
    @Singleton
    fun provideGoingOutInfoDao(
        database: Database
    ): GoingOutInfoDao =
        database.goingOutInfoDao

    @Provides
    @Singleton
    fun provideMapDao(
        database: Database
    ): MapDao =
        database.mapDao

    @Provides
    @Singleton
    fun provideScheduleDao(
        database: Database
    ): ScheduleDao =
        database.scheduleDao

    @Provides
    @Singleton
    fun provideMealDao(
        database: Database
    ): MealDao =
        database.mealDao

    @Provides
    @Singleton
    fun provideNoticeDao(
        database: Database
    ): NoticeDao =
        database.noticeDao

}
