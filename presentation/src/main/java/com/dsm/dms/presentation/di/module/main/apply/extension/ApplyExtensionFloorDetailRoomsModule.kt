package com.dsm.dms.presentation.di.module.main.apply.extension

import com.dsm.dms.presentation.di.scope.RoomsScope
import com.dsm.dms.presentation.ui.fragment.apply.extension.rooms.*
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ApplyExtensionFloorDetailRoomsModule {

    @RoomsScope
    @ContributesAndroidInjector
    abstract fun firstRoomsFragment(): FirstRoomsFragment

    @RoomsScope
    @ContributesAndroidInjector
    abstract fun secondRoomsFragment(): SecondRoomsFragment

    @RoomsScope
    @ContributesAndroidInjector
    abstract fun thirdRoomsFragment(): ThirdRoomsFragment

    @RoomsScope
    @ContributesAndroidInjector
    abstract fun fourthRoomsFragment(): FourthRoomsFragment

    @RoomsScope
    @ContributesAndroidInjector
    abstract fun fifthRoomsFragment(): FifthRoomsFragment

}
