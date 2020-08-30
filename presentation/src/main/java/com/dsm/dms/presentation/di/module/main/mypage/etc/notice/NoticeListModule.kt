package com.dsm.dms.presentation.di.module.main.mypage.etc.notice

import com.dsm.dms.presentation.di.scope.MyPageFragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice.NoticeListViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class NoticeListModule {
    @MyPageFragmentScope
    @Provides
    fun provideViewModelFactory(): NoticeListViewModelFactory
            = NoticeListViewModelFactory()
}
