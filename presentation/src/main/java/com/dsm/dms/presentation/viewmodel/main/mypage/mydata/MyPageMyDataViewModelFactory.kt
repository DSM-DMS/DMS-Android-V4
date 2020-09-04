package com.dsm.dms.presentation.viewmodel.main.mypage.mydata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MyPageMyDataViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()
}
