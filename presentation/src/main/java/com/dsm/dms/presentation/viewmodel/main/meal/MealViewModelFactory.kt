package com.dsm.dms.presentation.viewmodel.main.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.domain.usecase.GetMealUseCase

class MealViewModelFactory(
    private val getMeal: GetMealUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
        GetMealUseCase::class.java
    ).newInstance(getMeal)

}