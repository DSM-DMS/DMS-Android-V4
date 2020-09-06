package com.dsm.dms.presentation.di.module.main.apply.staying

import com.dsm.dms.data.datasource.StayDataSource
import com.dsm.dms.data.datasource.StayDataSourceImpl
import com.dsm.dms.data.local.database.Database
import com.dsm.dms.data.local.database.dao.UserDao
import com.dsm.dms.data.remote.ApplyApi
import com.dsm.dms.data.repository.StayRepositoryImpl
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.repository.StayRepository
import com.dsm.dms.domain.service.StayService
import com.dsm.dms.domain.service.StayServiceImpl
import com.dsm.dms.domain.usecase.ApplyStayUseCase
import com.dsm.dms.domain.usecase.GetStayInfoUseCase
import com.dsm.dms.presentation.di.scope.ApplyFragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.staying.ApplyStayingViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ApplyStayingModule {
    @ApplyFragmentScope
    @Provides
    fun provideViewModelFactory(
        getStayInfoUseCase: GetStayInfoUseCase,
        applyStayUseCase: ApplyStayUseCase
    ): ApplyStayingViewModelFactory =
        ApplyStayingViewModelFactory(
            getStayInfoUseCase,
            applyStayUseCase
        )

    @ApplyFragmentScope
    @Provides
    fun provideGetStayInfo(
        stayService: StayService,
        composite: CompositeDisposable
    ): GetStayInfoUseCase =
        GetStayInfoUseCase(stayService, composite)

    @ApplyFragmentScope
    @Provides
    fun provideApplyStay(
        stayService: StayService,
        composite: CompositeDisposable
    ): ApplyStayUseCase =
        ApplyStayUseCase(stayService, composite)

    @ApplyFragmentScope
    @Provides
    fun provideStayService(
        stayRepository: StayRepository,
        handler: ErrorHandler
    ): StayService =
        StayServiceImpl(stayRepository, handler)

    @ApplyFragmentScope
    @Provides
    fun provideStayRepository(
        stayDataSource: StayDataSource
    ): StayRepository =
        StayRepositoryImpl(stayDataSource)

    @ApplyFragmentScope
    @Provides
    fun provideStayDataSource(
        applyApi: ApplyApi,
        userDao: UserDao
    ): StayDataSource =
        StayDataSourceImpl(applyApi, userDao)

    @ApplyFragmentScope
    @Provides
    fun provideUserDao(
        database: Database
    ): UserDao =
        database.userDao

}