package com.dsm.dms.presentation.di.module.main.mypage

import com.dsm.dms.presentation.di.module.main.mypage.etc.notice.NoticeDetailModule
import com.dsm.dms.presentation.di.module.main.mypage.etc.notice.NoticeListModule
import com.dsm.dms.presentation.di.module.main.mypage.etc.setting.SettingModule
import com.dsm.dms.presentation.di.module.main.mypage.main.MyPageMainModule
import com.dsm.dms.presentation.di.scope.MyPageFragmentScope
import com.dsm.dms.presentation.ui.fragment.mypage.etc.notice.NoticeDetailFragment
import com.dsm.dms.presentation.ui.fragment.mypage.etc.notice.NoticeListFragment
import com.dsm.dms.presentation.ui.fragment.mypage.etc.setting.SettingFragment
import com.dsm.dms.presentation.ui.fragment.mypage.main.MyPageMainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MyPageModule {

    @MyPageFragmentScope
    @ContributesAndroidInjector(modules = [MyPageMainModule::class])
    abstract fun myPageMainFragment(): MyPageMainFragment

    @MyPageFragmentScope
    @ContributesAndroidInjector(modules = [NoticeDetailModule::class])
    abstract fun noticeDetailFragment(): NoticeDetailFragment

    @MyPageFragmentScope
    @ContributesAndroidInjector(modules = [NoticeListModule::class])
    abstract fun noticeListFragment(): NoticeListFragment

    @MyPageFragmentScope
    @ContributesAndroidInjector(modules = [SettingModule::class])
    abstract fun settingFragment(): SettingFragment

}
