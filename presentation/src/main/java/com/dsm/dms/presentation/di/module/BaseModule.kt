package com.dsm.dms.presentation.di.module

import com.dsm.dms.data.base.ErrorHandlerImpl
import com.dsm.dms.domain.base.ErrorHandler
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class BaseModule {

    @Provides
    @Singleton
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @Singleton
    fun provideErrorHandler(): ErrorHandler = ErrorHandlerImpl()

}