package com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class NoticeListViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()

}
