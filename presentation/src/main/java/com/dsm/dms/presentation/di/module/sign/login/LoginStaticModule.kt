package com.dsm.dms.presentation.di.module.sign.login

import com.dsm.dms.presentation.di.scope.SignFragmentScope
import com.dsm.dms.presentation.viewmodel.sign.login.LoginViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class LoginStaticModule {
    @SignFragmentScope
    @Provides
    fun provideViewModelFactory(): LoginViewModelFactory = LoginViewModelFactory()
}