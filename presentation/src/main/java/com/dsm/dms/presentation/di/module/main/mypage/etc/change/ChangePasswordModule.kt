package com.dsm.dms.presentation.di.module.main.mypage.etc.change

import com.dsm.dms.data.datasource.AccountDataSource
import com.dsm.dms.data.datasource.AccountDataSourceImpl
import com.dsm.dms.data.local.pref.LocalStorage
import com.dsm.dms.data.remote.AccountApi
import com.dsm.dms.data.repository.AccountRepositoryImpl
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.repository.AccountRepository
import com.dsm.dms.domain.service.AccountService
import com.dsm.dms.domain.service.AccountServiceImpl
import com.dsm.dms.domain.usecase.ChangePasswordUseCase
import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.change.ChangePasswordViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class ChangePasswordModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(
        changePasswordUseCase: ChangePasswordUseCase
    ): ChangePasswordViewModelFactory =
        ChangePasswordViewModelFactory(changePasswordUseCase)

    @FragmentScope
    @Provides
    fun provideChangePasswordUseCase(
        accountService: AccountService,
        composite: CompositeDisposable
    ): ChangePasswordUseCase =
        ChangePasswordUseCase(accountService, composite)

    @FragmentScope
    @Provides
    fun provideAccountService(
        accountRepository: AccountRepository,
        handler: ErrorHandler
    ): AccountService =
        AccountServiceImpl(accountRepository, handler)

    @FragmentScope
    @Provides
    fun provideAccountRepository(
        accountDataSource: AccountDataSource
    ): AccountRepository =
        AccountRepositoryImpl(accountDataSource)

    @FragmentScope
    @Provides
    fun provideAccountDataSource(
        accountApi: AccountApi,
        localStorage: LocalStorage
    ): AccountDataSource =
        AccountDataSourceImpl(accountApi, localStorage)

}
