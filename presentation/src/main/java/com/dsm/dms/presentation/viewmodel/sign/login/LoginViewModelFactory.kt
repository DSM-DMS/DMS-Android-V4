package com.dsm.dms.presentation.viewmodel.sign.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.domain.usecase.SignInUseCase


class LoginViewModelFactory(private val signInUseCase: SignInUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(SignInUseCase::class.java).newInstance(signInUseCase)
}
