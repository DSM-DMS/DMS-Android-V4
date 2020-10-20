package com.dsm.dms.presentation.di.module.main.meal

import com.dsm.dms.data.datasource.MealDataSource
import com.dsm.dms.data.datasource.MealDataSourceImpl
import com.dsm.dms.data.local.database.Database
import com.dsm.dms.data.local.database.dao.MealDao
import com.dsm.dms.data.remote.MealApi
import com.dsm.dms.data.repository.MealRepositoryImpl
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.repository.MealRepository
import com.dsm.dms.domain.service.MealService
import com.dsm.dms.domain.service.MealServiceImpl
import com.dsm.dms.domain.usecase.GetMealUseCase
import com.dsm.dms.presentation.di.scope.MainFragmentScope
import com.dsm.dms.presentation.viewmodel.main.meal.MealViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class MealStaticModule {

    @MainFragmentScope
    @Provides
    fun provideViewModelFactory(
        getMealUseCase: GetMealUseCase
    ): MealViewModelFactory =
        MealViewModelFactory(getMealUseCase)

    @MainFragmentScope
    @Provides
    fun provideGetMealUseCase(
        mealService: MealService,
        composite: CompositeDisposable
    ): GetMealUseCase =
        GetMealUseCase(mealService, composite)

    @MainFragmentScope
    @Provides
    fun provideMealService(
        mealRepository: MealRepository,
        handler: ErrorHandler
    ): MealService =
        MealServiceImpl(mealRepository, handler)

    @MainFragmentScope
    @Provides
    fun provideMealRepository(
        mealDataSource: MealDataSource
    ): MealRepository =
        MealRepositoryImpl(mealDataSource)

    @MainFragmentScope
    @Provides
    fun provideMealDataSource(
        api: MealApi,
        mealDao: MealDao
    ): MealDataSource =
        MealDataSourceImpl(api, mealDao)

}