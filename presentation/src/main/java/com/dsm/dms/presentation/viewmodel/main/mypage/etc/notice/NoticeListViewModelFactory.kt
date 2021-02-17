package com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.domain.usecase.GetNoticeListUseCase


class NoticeListViewModelFactory(
    private val getNoticeListUseCase: GetNoticeListUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor(
        getNoticeListUseCase::class.java
    ).newInstance(getNoticeListUseCase)

}
