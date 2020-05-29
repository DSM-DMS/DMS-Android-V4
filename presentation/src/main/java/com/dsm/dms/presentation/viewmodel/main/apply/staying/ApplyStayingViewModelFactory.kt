package com.dsm.dms.presentation.viewmodel.main.apply.staying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ApplyStayingViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()
}