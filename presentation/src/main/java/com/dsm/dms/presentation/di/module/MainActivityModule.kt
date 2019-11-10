package com.dsm.dms.presentation.di.module

import com.dsm.dms.presentation.di.module.main.MainModule
import com.dsm.dms.presentation.di.module.main.MainStaticModule
import com.dsm.dms.presentation.di.module.sign.SignModule
import com.dsm.dms.presentation.di.module.sign.SignStaticModule
import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.ui.fragment.MainFragment
import com.dsm.dms.presentation.ui.fragment.sign.SignFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainStaticModule::class])
    abstract fun mainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [SignModule::class, SignStaticModule::class])
    abstract fun signFragment(): SignFragment
}