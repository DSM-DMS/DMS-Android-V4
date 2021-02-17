package com.dsm.dms.presentation.di.app

import com.dsm.dms.data.local.pref.LocalStorage
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.applyDarkMode
import com.dsm.dms.presentation.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject


class BaseApp: DaggerApplication() {

    @Inject
    lateinit var localStorage: LocalStorage

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        applyDarkMode(
            localStorage.getSetting(
                resources.getString(R.string.mypage_setting_dark_mode_title)
            )
        )
    }
}
