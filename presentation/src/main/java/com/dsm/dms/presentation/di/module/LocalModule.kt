package com.dsm.dms.presentation.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import android.content.Context
import com.dsm.dms.data.local.pref.LocalStorage
import com.dsm.dms.data.local.pref.SharedPrefStorage


@Module
class LocalModule {

    @Provides
    @Singleton
    fun provideLocalStorage(context: Context) : LocalStorage = SharedPrefStorage(context)
}