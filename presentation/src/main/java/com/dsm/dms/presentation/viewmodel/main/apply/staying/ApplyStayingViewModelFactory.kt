package com.dsm.dms.presentation.viewmodel.main.apply.staying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.domain.usecase.ApplyStayUseCase
import com.dsm.dms.domain.usecase.GetStayInfoUseCase

class ApplyStayingViewModelFactory(
    private val getStayInfoUseCase: GetStayInfoUseCase,
    private val applyStayingUseCase: ApplyStayUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor(
        GetStayInfoUseCase::class.java,
        ApplyStayUseCase::class.java
    ).newInstance(
        getStayInfoUseCase,
        applyStayingUseCase
    )
}