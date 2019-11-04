package com.dsm.dms.presentation.di.module.sign

import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.sign.SignViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SignStaticModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(): SignViewModelFactory = SignViewModelFactory()
}