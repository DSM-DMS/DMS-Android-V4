package com.dsm.dms.presentation.di.module.main.mypage.etc.point

import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.point.PointViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class PointModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(): PointViewModelFactory
            = PointViewModelFactory()
}
