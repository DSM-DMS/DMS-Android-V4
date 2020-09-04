package com.dsm.dms.presentation.di.module.main.apply.rest

import com.dsm.dms.presentation.di.scope.ApplyFragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.rest.ApplyWeekendRestViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ApplyWeekendRestModule {
    @ApplyFragmentScope
    @Provides
    fun provideViewModelFactory(): ApplyWeekendRestViewModelFactory
            = ApplyWeekendRestViewModelFactory()
}
