package com.dsm.dms.presentation.di.module.main.login

import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.sign.login.LoginViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class LoginStaticModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(): LoginViewModelFactory = LoginViewModelFactory()
}