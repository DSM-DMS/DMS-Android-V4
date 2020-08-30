package com.dsm.dms.presentation.di.module.main.apply

import com.dsm.dms.presentation.di.module.main.apply.extension.ApplyExtensionFloorDetailModule
import com.dsm.dms.presentation.di.module.main.apply.extension.ApplyExtensionFloorListModule
import com.dsm.dms.presentation.di.module.main.apply.main.ApplyMainModule
import com.dsm.dms.presentation.di.module.main.apply.staying.ApplyStayingModule
import com.dsm.dms.presentation.di.scope.ApplyFragmentScope
import com.dsm.dms.presentation.ui.fragment.apply.extension.ApplyExtensionFloorDetailFragment
import com.dsm.dms.presentation.ui.fragment.apply.extension.ApplyExtensionFloorListFragment
import com.dsm.dms.presentation.ui.fragment.apply.main.ApplyMainFragment
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
}
