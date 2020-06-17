package com.dsm.dms.presentation.di.module.main.mypage.etc

import com.dsm.dms.presentation.di.scope.MyPageFragmentScope
import com.dsm.dms.presentation.ui.fragment.mypage.etc.MyPageEtcFragment
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.MyPageEtcViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MyPageEtcModule {
    @MyPageFragmentScope
    @Provides
    fun provideFragment(factory: MyPageEtcViewModelFactory): MyPageEtcFragment
            = MyPageEtcFragment(factory)

    @MyPageFragmentScope
    @Provides
    fun provideViewModelFactory(): MyPageEtcViewModelFactory
            = MyPageEtcViewModelFactory()
}
