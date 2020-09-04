package com.dsm.dms.presentation.di.module

import android.app.Application
import android.content.Context
import com.dsm.dms.presentation.di.app.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [(NetworkModule::class), (LocalModule::class)])
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: BaseApp): Context = application

    @Provides
    @Singleton
    fun provideApplication(app: BaseApp): Application = app
}