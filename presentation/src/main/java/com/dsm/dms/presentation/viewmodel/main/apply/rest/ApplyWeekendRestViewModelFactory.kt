package com.dsm.dms.presentation.viewmodel.main.apply.rest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ApplyWeekendRestViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()
}
