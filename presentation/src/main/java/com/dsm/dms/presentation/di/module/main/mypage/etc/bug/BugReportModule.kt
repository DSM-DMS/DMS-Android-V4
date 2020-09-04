package com.dsm.dms.presentation.di.module.main.mypage.etc.bug

import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.bug.BugReportViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class BugReportModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(): BugReportViewModelFactory
            = BugReportViewModelFactory()
}
