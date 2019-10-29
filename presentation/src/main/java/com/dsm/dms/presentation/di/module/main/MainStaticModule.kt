package com.dsm.dms.presentation.di.module.main

import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.main.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainStaticModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(): MainViewModelFactory
            = MainViewModelFactory()
}