package com.dsm.dms.presentation.di.module.main.chatting

import com.dsm.dms.presentation.di.scope.MainFragmentScope
import com.dsm.dms.presentation.viewmodel.main.ChattingViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ChattingStaticModule {
    @MainFragmentScope
    @Provides
    fun provideViewModelFactory(): ChattingViewModelFactory
            = ChattingViewModelFactory()
}