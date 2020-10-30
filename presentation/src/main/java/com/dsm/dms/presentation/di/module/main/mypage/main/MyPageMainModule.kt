package com.dsm.dms.presentation.di.module.main.mypage.main

import com.dsm.dms.presentation.di.scope.MyPageFragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.main.MyPageMainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MyPageMainModule {

    @MyPageFragmentScope
    @Provides
    fun provideViewModelFactory(): MyPageMainViewModelFactory
            = MyPageMainViewModelFactory()

}
