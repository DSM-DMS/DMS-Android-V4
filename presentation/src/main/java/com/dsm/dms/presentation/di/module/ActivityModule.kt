package com.dsm.dms.presentation.di.module

import com.dsm.dms.presentation.di.scope.ActivityScope
import com.dsm.dms.presentation.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}