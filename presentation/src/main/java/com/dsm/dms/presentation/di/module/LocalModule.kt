package com.dsm.dms.presentation.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import android.content.Context
import androidx.room.Room
import com.dsm.dms.data.local.database.Database
import com.dsm.dms.data.local.pref.LocalStorage
import com.dsm.dms.data.local.pref.SharedPrefStorage


@Module
class LocalModule {

    @Provides
    @Singleton
    fun provideLocalStorage(context: Context) : LocalStorage = SharedPrefStorage(context)

    @Provides
    @Singleton
    fun provideDatabase(
        context: Context
    ): Database =
        Room.databaseBuilder(context, Database::class.java, "dms.db").build()

}
