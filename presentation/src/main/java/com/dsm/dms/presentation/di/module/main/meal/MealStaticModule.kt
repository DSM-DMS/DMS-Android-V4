package com.dsm.dms.presentation.di.module.main.meal

import com.dsm.dms.presentation.di.scope.MainFragmentScope
import com.dsm.dms.presentation.viewmodel.main.MealViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MealStaticModule {
    @MainFragmentScope
    @Provides
    fun provideViewModelFactory(): MealViewModelFactory
            = MealViewModelFactory()
}