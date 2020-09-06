package com.dsm.dms.presentation.viewmodel.main.mypage.etc.change

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.domain.usecase.ChangePasswordUseCase


class ChangePasswordViewModelFactory(
    private val changePasswordUseCase: ChangePasswordUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor(ChangePasswordUseCase::class.java).newInstance(changePasswordUseCase)

}
