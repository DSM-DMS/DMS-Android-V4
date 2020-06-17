package com.dsm.dms.presentation.viewmodel.main.mypage.etc.point

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class PointViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()

}
