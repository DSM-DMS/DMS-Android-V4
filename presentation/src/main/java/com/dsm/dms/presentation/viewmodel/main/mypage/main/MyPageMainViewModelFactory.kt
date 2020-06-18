package com.dsm.dms.presentation.viewmodel.main.mypage.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyPageMainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()

}
