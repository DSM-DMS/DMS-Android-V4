package com.dsm.dms.presentation.di.module.main.mypage.main

import com.dsm.dms.presentation.adapter.ViewPagerFragmentAdapter
import com.dsm.dms.presentation.di.scope.MyPageFragmentScope
import com.dsm.dms.presentation.ui.activity.MainActivity
import com.dsm.dms.presentation.ui.fragment.mypage.etc.MyPageEtcFragment
import com.dsm.dms.presentation.ui.fragment.mypage.mydata.MyPageMyDataFragment
import com.dsm.dms.presentation.viewmodel.main.mypage.main.MyPageMainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MyPageMainModule {

    @MyPageFragmentScope
    @Provides
    fun provideViewModelFactory(): MyPageMainViewModelFactory
            = MyPageMainViewModelFactory()

    @MyPageFragmentScope
    @Provides
    fun provideViewPagerFragmentAdapter(
            mainActivity: MainActivity,
            myPageMyDataFragment: MyPageMyDataFragment,
            myPageEtcFragment: MyPageEtcFragment
    ): ViewPagerFragmentAdapter
            = ViewPagerFragmentAdapter(mainActivity).apply {
        fragments.add(myPageMyDataFragment)
        fragments.add(myPageEtcFragment)
    }

}
