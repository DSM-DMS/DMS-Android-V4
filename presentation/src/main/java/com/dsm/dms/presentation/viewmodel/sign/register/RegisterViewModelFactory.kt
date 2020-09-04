package com.dsm.dms.presentation.viewmodel.sign.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.domain.usecase.SignUpUseCase
import com.dsm.dms.domain.usecase.VerifyCertificationCodeUseCase

class RegisterViewModelFactory(
    private val signUpUseCase: SignUpUseCase,
    private val verifyCertificationCodeUseCase: VerifyCertificationCodeUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            SignUpUseCase::class.java,
            VerifyCertificationCodeUseCase::class.java
        ).newInstance(signUpUseCase, verifyCertificationCodeUseCase)

}