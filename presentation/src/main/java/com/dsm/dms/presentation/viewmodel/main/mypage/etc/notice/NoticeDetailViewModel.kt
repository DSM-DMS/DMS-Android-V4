package com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem
import com.dsm.dms.presentation.model.NoticeModel


class NoticeDetailViewModel: BaseViewModel() {

    val notice = MutableLiveData<NoticeModel>()

    val backToList = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun clickBack() = backToList.call()

}
