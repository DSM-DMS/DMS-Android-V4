package com.dsm.dms.presentation.di.module.sign.register

import com.dsm.dms.presentation.di.scope.RegisterFragmentScope
import com.dsm.dms.presentation.ui.fragment.sign.register.account.certify.CertifyAccountFragment
import com.dsm.dms.presentation.ui.fragment.sign.register.account.complete.RegisterCompleteFragment
import com.dsm.dms.presentation.ui.fragment.sign.register.account.create.CreateAccountFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RegisterModule {
    @RegisterFragmentScope
    @ContributesAndroidInjector
    abstract fun createAccountFragment(): CreateAccountFragment

    @RegisterFragmentScope
    @ContributesAndroidInjector
    abstract fun certifyAccountFragment(): CertifyAccountFragment

    @RegisterFragmentScope
    @ContributesAndroidInjector
    abstract fun registerCompleteFragment(): RegisterCompleteFragment
}