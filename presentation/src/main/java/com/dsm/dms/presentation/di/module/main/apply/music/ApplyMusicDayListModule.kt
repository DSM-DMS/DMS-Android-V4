package com.dsm.dms.presentation.di.module.main.apply.music

import com.dsm.dms.presentation.di.scope.ApplyFragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.music.ApplyMusicDayListViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ApplyMusicDayListModule {
    @ApplyFragmentScope
    @Provides
    fun provideViewModelFactory(): ApplyMusicDayListViewModelFactory
            = ApplyMusicDayListViewModelFactory()
}
