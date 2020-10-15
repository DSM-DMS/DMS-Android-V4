package com.dsm.dms.presentation.viewmodel.main.apply.extension.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.domain.usecase.ApplyExtensionUseCase
import com.dsm.dms.domain.usecase.GetExtensionMapUseCase

class ApplyExtensionFloorDetailViewModelFactory(
    private val getExtensionMapUseCase: GetExtensionMapUseCase,
    private val applyExtensionUseCase: ApplyExtensionUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor(
        GetExtensionMapUseCase::class.java,
        ApplyExtensionUseCase::class.java
    ).newInstance(getExtensionMapUseCase, applyExtensionUseCase)
}
