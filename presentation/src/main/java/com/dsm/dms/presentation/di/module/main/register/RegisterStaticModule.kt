package com.dsm.dms.presentation.di.module.main.register

import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.data.datasource.AccountDataSource
import com.dsm.dms.data.datasource.AccountDataSourceImpl
import com.dsm.dms.data.local.pref.LocalStorage
import com.dsm.dms.data.remote.AccountApi
import com.dsm.dms.data.repository.AccountRepositoryImpl
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.repository.AccountRepository
import com.dsm.dms.domain.service.AccountService
import com.dsm.dms.domain.service.AccountServiceImpl
import com.dsm.dms.domain.usecase.SignUpUseCase
import com.dsm.dms.domain.usecase.VerifyCertificationCodeUseCase
import com.dsm.dms.presentation.di.scope.FragmentScope
import com.dsm.dms.presentation.ui.fragment.sign.register.RegisterFragment
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class RegisterStaticModule {
    @FragmentScope
    @Provides
    fun provideViewModelFactory(
        signUpUseCase: SignUpUseCase,
        verifyCertificationCodeUseCase: VerifyCertificationCodeUseCase
    ): RegisterViewModelFactory =
        RegisterViewModelFactory(signUpUseCase, verifyCertificationCodeUseCase)

    @FragmentScope
    @Provides
    fun provideViewModel(
        registerFragment: RegisterFragment,
        factory: RegisterViewModelFactory
    ): RegisterViewModel =
        ViewModelProvider(registerFragment, factory).get(RegisterViewModel::class.java)

    @FragmentScope
    @Provides
    fun provideSignUpUseCase(
        accountService: AccountService,
        composite: CompositeDisposable
    ): SignUpUseCase =
        SignUpUseCase(accountService, composite)

    @FragmentScope
    @Provides
    fun provideVerifyCertificationCodeUseCase(
        accountService: AccountService,
        composite: CompositeDisposable
    ): VerifyCertificationCodeUseCase =
        VerifyCertificationCodeUseCase(accountService, composite)

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