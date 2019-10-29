package com.dsm.dms.presentation.di.module.main.apply

import com.dsm.dms.presentation.di.scope.MainFragmentScope
import com.dsm.dms.presentation.viewmodel.main.ApplyViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ApplyStaticModule {
    @MainFragmentScope
    @Provides
    fun provideViewModelFactory(): ApplyViewModelFactory
            = ApplyViewModelFactory()
}