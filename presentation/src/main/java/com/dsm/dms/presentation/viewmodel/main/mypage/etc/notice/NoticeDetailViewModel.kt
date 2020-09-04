package com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem


class NoticeDetailViewModel: BaseViewModel() {

    val date = MutableLiveData<String>()
    val viewCount = MutableLiveData<String>()
    val noticeTitle = MutableLiveData<String>()
    val noticeContent = MutableLiveData<String>()

    val backToList = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun clickBack() = backToList.call()

}
