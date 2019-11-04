package com.dsm.dms.presentation.di.module.sign

import com.dsm.dms.presentation.di.module.sign.login.LoginStaticModule
import com.dsm.dms.presentation.di.module.sign.register.RegisterCompleteStaticModule
import com.dsm.dms.presentation.di.module.sign.register.RegisterModule
import com.dsm.dms.presentation.di.module.sign.register.RegisterStaticModule
import com.dsm.dms.presentation.di.scope.SignFragmentScope
import com.dsm.dms.presentation.ui.fragment.sign.login.LoginFragment
import com.dsm.dms.presentation.ui.fragment.sign.register.RegisterCompleteFragment
import com.dsm.dms.presentation.ui.fragment.sign.register.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SignModule {
    @SignFragmentScope
    @ContributesAndroidInjector(modules = [LoginStaticModule::class])
    abstract fun loginFragment(): LoginFragment

    @SignFragmentScope
    @ContributesAndroidInjector(modules = [RegisterModule::class, RegisterStaticModule::class])
    abstract fun registerFragment(): RegisterFragment

    @SignFragmentScope
    @ContributesAndroidInjector(modules = [RegisterCompleteStaticModule::class])
    abstract fun reegisterCompleteFragment(): RegisterCompleteFragment
}