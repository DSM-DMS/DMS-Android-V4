package com.dsm.dms.presentation.di.module.main.apply.extension

import com.dsm.dms.presentation.di.scope.ApplyFragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.extension.ApplyExtensionFloorListViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ApplyExtensionFloorListModule {
    @ApplyFragmentScope
    @Provides
    fun provideViewModelFactory(): ApplyExtensionFloorListViewModelFactory
            = ApplyExtensionFloorListViewModelFactory()
}
