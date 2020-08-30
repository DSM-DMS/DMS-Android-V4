package com.dsm.dms.presentation.di.module.main.mypage.etc.notice

import com.dsm.dms.presentation.di.scope.MyPageFragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice.NoticeDetailViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class NoticeDetailModule {
    @MyPageFragmentScope
    @Provides
    fun provideViewModelFactory(): NoticeDetailViewModelFactory
            = NoticeDetailViewModelFactory()
}
