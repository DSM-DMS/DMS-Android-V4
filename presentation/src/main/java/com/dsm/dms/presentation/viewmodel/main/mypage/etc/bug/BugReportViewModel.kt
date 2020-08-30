package com.dsm.dms.presentation.viewmodel.main.mypage.etc.bug

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem


class BugReportViewModel: BaseViewModel() {

    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    val backToMyPageEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun backClick() = backToMyPageEvent.call()

    fun clickSend() {
        backToMyPageEvent.call()
    }

}
