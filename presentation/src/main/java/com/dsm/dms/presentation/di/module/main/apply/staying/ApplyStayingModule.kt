package com.dsm.dms.presentation.di.module.main.apply.staying

import com.dsm.dms.presentation.di.scope.ApplyFragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.staying.ApplyStayingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ApplyStayingModule {
    @ApplyFragmentScope
    @Provides
    fun provideViewModelFactory(): ApplyStayingViewModelFactory
            = ApplyStayingViewModelFactory()
}