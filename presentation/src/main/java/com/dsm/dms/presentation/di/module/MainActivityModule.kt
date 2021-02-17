package com.dsm.dms.presentation.di.module

import com.dsm.dms.presentation.di.module.main.MainModule
import com.dsm.dms.presentation.di.module.main.MainStaticModule
import com.dsm.dms.presentation.di.module.main.apply.extension.ApplyExtensionFloorDetailModule
import com.dsm.dms.presentation.di.module.main.apply.music.apply.ApplyMusicApplyModule
import com.dsm.dms.presentation.di.module.main.login.LoginStaticModule
import com.dsm.dms.presentation.di.module.main.mypage.etc.bug.BugReportModule
import com.dsm.dms.presentation.di.module.main.mypage.etc.change.ChangePasswordModule
import com.dsm.dms.presentation.di.module.main.mypage.etc.point.PointModule
import com.dsm.dms.presentation.di.module.main.register.RegisterModule
import com.dsm.dms.presentation.di.module.main.register.RegisterStaticModule
import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.ui.fragment.MainFragment
import com.dsm.dms.presentation.ui.fragment.apply.extension.ApplyExtensionFloorDetailFragment
import com.dsm.dms.presentation.ui.fragment.mypage.etc.bug.BugReportFragment
import com.dsm.dms.presentation.ui.fragment.mypage.etc.change.ChangePasswordFragment
import com.dsm.dms.presentation.ui.fragment.mypage.etc.point.PointFragment
import com.dsm.dms.presentation.ui.fragment.apply.music.apply.ApplyMusicApplyFragment
import com.dsm.dms.presentation.ui.fragment.sign.login.LoginFragment
import com.dsm.dms.presentation.ui.fragment.sign.register.RegisterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainStaticModule::class])
    abstract fun mainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [LoginStaticModule::class])
    abstract fun loginFragment(): LoginFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [RegisterModule::class, RegisterStaticModule::class])
    abstract fun registerFragment(): RegisterFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ApplyExtensionFloorDetailModule::class])
    abstract fun applyExtensionsFloorDetailFragment(): ApplyExtensionFloorDetailFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [BugReportModule::class])
    abstract fun bugReportFragment(): BugReportFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ChangePasswordModule::class])
    abstract fun changePasswordFragment(): ChangePasswordFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PointModule::class])
    abstract fun pointFragment(): PointFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ApplyMusicApplyModule::class])
    abstract fun applyMusicApplyFragment(): ApplyMusicApplyFragment

}