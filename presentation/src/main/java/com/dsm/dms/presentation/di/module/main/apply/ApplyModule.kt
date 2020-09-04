package com.dsm.dms.presentation.di.module.main.apply

import com.dsm.dms.presentation.di.module.main.apply.extension.ApplyExtensionFloorListModule
import com.dsm.dms.presentation.di.module.main.apply.main.ApplyMainModule
import com.dsm.dms.presentation.di.module.main.apply.rest.ApplyWeekendRestModule
import com.dsm.dms.presentation.di.module.main.apply.music.ApplyMusicDayListModule
import com.dsm.dms.presentation.di.module.main.apply.music.detail.ApplyMusicDayDetailListModule
import com.dsm.dms.presentation.di.module.main.apply.staying.ApplyStayingModule
import com.dsm.dms.presentation.di.scope.ApplyFragmentScope
import com.dsm.dms.presentation.ui.fragment.apply.extension.ApplyExtensionFloorListFragment
import com.dsm.dms.presentation.ui.fragment.apply.main.ApplyMainFragment
import com.dsm.dms.presentation.ui.fragment.apply.rest.ApplyWeekendRestFragment
import com.dsm.dms.presentation.ui.fragment.apply.music.ApplyMusicDayListFragment
import com.dsm.dms.presentation.ui.fragment.apply.music.detail.ApplyMusicDayDetailListFragment
import com.dsm.dms.presentation.ui.fragment.apply.staying.ApplyStayingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ApplyModule {
    @ApplyFragmentScope
    @ContributesAndroidInjector(modules = [ApplyStayingModule::class])
    abstract fun applyStayingFragment(): ApplyStayingFragment

    @ApplyFragmentScope
    @ContributesAndroidInjector(modules = [ApplyMainModule::class])
    abstract fun applyMainFragment(): ApplyMainFragment

    @ApplyFragmentScope
    @ContributesAndroidInjector(modules = [ApplyExtensionFloorListModule::class])
    abstract fun applyExtensionFloorListFragment(): ApplyExtensionFloorListFragment

    @ApplyFragmentScope
    @ContributesAndroidInjector(modules = [ApplyWeekendRestModule::class])
    abstract fun applyWeekendRestFragment(): ApplyWeekendRestFragment

    @ApplyFragmentScope
    @ContributesAndroidInjector(modules = [ApplyMusicDayListModule::class])
    abstract fun applyMusicDayListFragment(): ApplyMusicDayListFragment

    @ApplyFragmentScope
    @ContributesAndroidInjector(modules = [ApplyMusicDayDetailListModule::class])
    abstract fun applyMusicDayDetailListFragment(): ApplyMusicDayDetailListFragment

}
