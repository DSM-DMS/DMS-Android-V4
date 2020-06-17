package com.dsm.dms.presentation.di.module.main.mypage.mydata

import com.dsm.dms.presentation.di.scope.MyPageFragmentScope
import com.dsm.dms.presentation.ui.fragment.mypage.mydata.MyPageMyDataFragment
import com.dsm.dms.presentation.viewmodel.main.mypage.mydata.MyPageMyDataViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MyPageMyDataModule {
    @MyPageFragmentScope
    @Provides
    fun provideFragment(factory: MyPageMyDataViewModelFactory): MyPageMyDataFragment
            = MyPageMyDataFragment(factory)

    @MyPageFragmentScope
    @Provides
    fun provideViewModelFactory(): MyPageMyDataViewModelFactory
            = MyPageMyDataViewModelFactory()
}
