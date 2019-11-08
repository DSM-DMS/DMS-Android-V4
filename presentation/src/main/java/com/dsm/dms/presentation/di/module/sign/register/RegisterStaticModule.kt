package com.dsm.dms.presentation.di.module.sign.register

import androidx.lifecycle.ViewModelProviders
import com.dsm.dms.presentation.di.scope.SignFragmentScope
import com.dsm.dms.presentation.ui.fragment.sign.register.RegisterFragment
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class RegisterStaticModule {
    @SignFragmentScope
    @Provides
    fun provideViewModelFactory(): RegisterViewModelFactory =
        RegisterViewModelFactory()

    @SignFragmentScope
    @Provides
    fun provideViewModel(
        registerFragment: RegisterFragment,
        factory: RegisterViewModelFactory
    ): RegisterViewModel =
        ViewModelProviders.of(registerFragment, factory).get(RegisterViewModel::class.java)
}