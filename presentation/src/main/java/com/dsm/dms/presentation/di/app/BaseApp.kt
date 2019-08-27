package com.dsm.dms.presentation.di.app

import androidx.preference.PreferenceManager
import com.dsm.dms.presentation.di.component.DaggerAppComponent
import com.dsm.dms.presentation.util.ThemeHelper
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val themePref = sharedPreferences.getString("themePref", ThemeHelper.DEFAULT_MODE)!!
        ThemeHelper.applyTheme(themePref)
    }
}