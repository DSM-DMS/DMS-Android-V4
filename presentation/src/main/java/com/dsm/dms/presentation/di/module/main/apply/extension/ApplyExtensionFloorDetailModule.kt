package com.dsm.dms.presentation.di.module.main.apply.extension

import com.dsm.dms.data.datasource.ExtensionDataSource
import com.dsm.dms.data.datasource.ExtensionDataSourceImpl
import com.dsm.dms.data.local.database.Database
import com.dsm.dms.data.local.database.dao.ExtensionInfoDao
import com.dsm.dms.data.local.database.dao.MapDao
import com.dsm.dms.data.remote.ApplyApi
import com.dsm.dms.data.repository.ExtensionRepositoryImpl
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.repository.ExtensionRepository
import com.dsm.dms.domain.service.ExtensionService
import com.dsm.dms.domain.service.ExtensionServiceImpl
import com.dsm.dms.domain.usecase.ApplyExtensionUseCase
import com.dsm.dms.domain.usecase.GetExtensionMapUseCase
import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.main.apply.extension.detail.ApplyExtensionFloorDetailViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class ApplyExtensionFloorDetailModule {

    @FragmentScope
    @Provides
    fun provideViewModelFactory(
        getExtensionMapUseCase: GetExtensionMapUseCase,
        applyExtensionUseCase: ApplyExtensionUseCase
    ): ApplyExtensionFloorDetailViewModelFactory =
        ApplyExtensionFloorDetailViewModelFactory(
            getExtensionMapUseCase, applyExtensionUseCase
        )

    @FragmentScope
    @Provides
    fun provideGetExtensionMapUseCase(
        service: ExtensionService,
        composite: CompositeDisposable
    ): GetExtensionMapUseCase =
        GetExtensionMapUseCase(service, composite)

    @FragmentScope
    @Provides
    fun provideApplyExtensionUseCase(
        extensionService: ExtensionService,
        composite: CompositeDisposable
    ): ApplyExtensionUseCase =
        ApplyExtensionUseCase(extensionService, composite)

    @FragmentScope
    @Provides
    fun provideExtensionService(
        extensionRepository: ExtensionRepository,
        handler: ErrorHandler
    ): ExtensionService =
        ExtensionServiceImpl(extensionRepository, handler)

    @FragmentScope
    @Provides
    fun provideExtensionRepository(
        extensionDataSource: ExtensionDataSource
    ): ExtensionRepository =
        ExtensionRepositoryImpl(extensionDataSource)

    @FragmentScope
    @Provides
    fun provideExtensionDataSource(
        api: ApplyApi,
        extensionInfoDao: ExtensionInfoDao,
        mapDao: MapDao
    ): ExtensionDataSource =
        ExtensionDataSourceImpl(api, extensionInfoDao, mapDao)

}
