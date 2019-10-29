package com.dsm.dms.presentation.di.module.main

import com.dsm.dms.presentation.di.module.main.apply.ApplyModule
import com.dsm.dms.presentation.di.module.main.apply.ApplyStaticModule
import com.dsm.dms.presentation.di.module.main.chatting.ChattingModule
import com.dsm.dms.presentation.di.module.main.chatting.ChattingStaticModule
import com.dsm.dms.presentation.di.module.main.meal.MealModule
import com.dsm.dms.presentation.di.module.main.meal.MealStaticModule
import com.dsm.dms.presentation.di.module.main.mypage.MyPageModule
import com.dsm.dms.presentation.di.module.main.mypage.MyPageStaticModule
import com.dsm.dms.presentation.di.scope.MainFragmentScope
import com.dsm.dms.presentation.ui.fragment.apply.ApplyFragment
import com.dsm.dms.presentation.ui.fragment.chatting.ChattingFragment
import com.dsm.dms.presentation.ui.fragment.meal.MealFragment
import com.dsm.dms.presentation.ui.fragment.mypage.MyPageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @MainFragmentScope
    @ContributesAndroidInjector(modules = [MyPageModule::class, MyPageStaticModule::class])
    abstract fun mypageFragment(): MyPageFragment

    @MainFragmentScope
    @ContributesAndroidInjector(modules = [ChattingModule::class, ChattingStaticModule::class])
    abstract fun chattingFragment(): ChattingFragment

    @MainFragmentScope
    @ContributesAndroidInjector(modules = [MealModule::class, MealStaticModule::class])
    abstract fun mealFragment(): MealFragment

    @MainFragmentScope
    @ContributesAndroidInjector(modules = [ApplyModule::class, ApplyStaticModule::class])
    abstract fun applyFragment(): ApplyFragment
}