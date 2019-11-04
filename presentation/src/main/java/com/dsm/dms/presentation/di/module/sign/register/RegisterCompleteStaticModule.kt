package com.dsm.dms.presentation.di.module.sign.register

import com.dsm.dms.presentation.di.scope.SignFragmentScope
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterCompleteViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class RegisterCompleteStaticModule {
    @SignFragmentScope
    @Provides
    fun provideViewModelFactory(): RegisterCompleteViewModelFactory =
        RegisterCompleteViewModelFactory()
}