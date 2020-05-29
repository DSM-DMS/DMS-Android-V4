package com.dsm.dms.presentation.di.module.main.apply.extension

import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ApplyExtensionFloorDetailModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(): ApplyExtensionFloorDetailViewModelFactory
            = ApplyExtensionFloorDetailViewModelFactory()
}
