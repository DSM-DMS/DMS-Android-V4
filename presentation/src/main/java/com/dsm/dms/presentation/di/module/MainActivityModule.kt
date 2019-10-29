package com.dsm.dms.presentation.di.module

import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.ui.fragment.MainFragment
import com.dsm.dms.presentation.di.module.main.MainModule
import com.dsm.dms.presentation.di.module.main.MainStaticModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainStaticModule::class])
    abstract fun mainFragment(): MainFragment
}