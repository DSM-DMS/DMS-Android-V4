package com.dsm.dms.presentation.di.module.main.register

import androidx.lifecycle.ViewModelProviders
import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.ui.fragment.sign.register.RegisterFragment
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class RegisterStaticModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(): RegisterViewModelFactory =
        RegisterViewModelFactory()

    @FragmentScope
    @Provides
    fun provideViewModel(
        registerFragment: RegisterFragment,
        factory: RegisterViewModelFactory
    ): RegisterViewModel =
        ViewModelProviders.of(registerFragment, factory).get(RegisterViewModel::class.java)
}