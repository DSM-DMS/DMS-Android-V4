package com.dsm.dms.presentation.di.module.main.mypage.etc.setting

import android.content.Context
import com.dsm.dms.presentation.base.ResourcesProvider
import com.dsm.dms.presentation.base.ResourcesProviderImpl
import com.dsm.dms.presentation.di.scope.MyPageFragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.setting.SettingViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class SettingModule {
    @MyPageFragmentScope
    @Provides
    fun provideViewModelFactory(resourcesProvider: ResourcesProvider): SettingViewModelFactory
            = SettingViewModelFactory(resourcesProvider)

    @MyPageFragmentScope
    @Provides
    fun provideResourcesProvider(context: Context): ResourcesProvider
            = ResourcesProviderImpl(context)
}
