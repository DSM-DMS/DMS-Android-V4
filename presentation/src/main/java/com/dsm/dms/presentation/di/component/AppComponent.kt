package com.dsm.dms.presentation.di.component

import com.dsm.dms.presentation.di.module.ActivityModule
import com.dsm.dms.presentation.di.module.AppModule
import com.dsm.dms.presentation.di.app.BaseApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (AppModule::class),
        (ActivityModule::class),
        (AndroidSupportInjectionModule::class)]
)
interface AppComponent: AndroidInjector<BaseApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApp): Builder
        fun build(): AppComponent
    }
}