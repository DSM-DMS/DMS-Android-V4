package com.dsm.dms.presentation.di.module.sign.register

import com.dsm.dms.presentation.di.scope.SignFragmentScope
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class RegisterStaticModule {
    @SignFragmentScope
    @Provides
    fun provideViewModelFactory(): RegisterViewModelFactory =
        RegisterViewModelFactory()
}