package com.dsm.dms.presentation.di.module.main.mypage.etc.change

import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.change.ChangePasswordViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ChangePasswordModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(): ChangePasswordViewModelFactory
            = ChangePasswordViewModelFactory()
}
