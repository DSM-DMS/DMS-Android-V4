package com.dsm.dms.presentation.di.module.main.apply.music.detail

import com.dsm.dms.presentation.di.scope.ApplyFragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.music.detail.ApplyMusicDayDetailListViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ApplyMusicDayDetailListModule {
    @ApplyFragmentScope
    @Provides
    fun provideViewModelFactory(): ApplyMusicDayDetailListViewModelFactory
            = ApplyMusicDayDetailListViewModelFactory()
}
