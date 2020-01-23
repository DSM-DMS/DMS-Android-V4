package com.dsm.dms.presentation.di.module.main.mypage

import com.dsm.dms.presentation.di.scope.MainFragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.MyPageViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MyPageStaticModule {
    @MainFragmentScope
    @Provides
    fun provideViewModelFactory(): MyPageViewModelFactory
            = MyPageViewModelFactory()
}