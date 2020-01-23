package com.dsm.dms.presentation.viewmodel.sign

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor().newInstance()

}