package com.dsm.dms.presentation.viewmodel.main.apply.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ApplyMainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()
}