package com.dsm.dms.presentation.di.module.main.apply.music.apply

import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.music.apply.ApplyMusicApplyViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ApplyMusicApplyModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(): ApplyMusicApplyViewModelFactory
            = ApplyMusicApplyViewModelFactory()
}
