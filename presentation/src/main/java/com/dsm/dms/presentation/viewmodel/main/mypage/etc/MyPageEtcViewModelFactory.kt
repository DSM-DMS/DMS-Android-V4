package com.dsm.dms.presentation.viewmodel.main.mypage.etc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MyPageEtcViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()

}
