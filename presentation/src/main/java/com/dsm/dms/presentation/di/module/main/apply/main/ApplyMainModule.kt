package com.dsm.dms.presentation.di.module.main.apply.main

import com.dsm.dms.presentation.di.scope.ApplyFragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.main.ApplyMainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ApplyMainModule {
    @ApplyFragmentScope
    @Provides
    fun provideViewModelFactory(): ApplyMainViewModelFactory
            = ApplyMainViewModelFactory()
}