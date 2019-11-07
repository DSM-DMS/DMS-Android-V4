package com.dsm.dms.presentation.viewmodel.main.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MealViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()

}