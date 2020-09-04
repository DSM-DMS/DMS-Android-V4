package com.dsm.dms.presentation.viewmodel.main.mypage.mydata

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem


class MyPageMyDataViewModel: BaseViewModel() {

    val name = MutableLiveData<String>().apply { value = "송진우" }
    val stayingStatus = MutableLiveData<String>().apply { value = "금요 귀가" }
    val goodPoint = MutableLiveData<String>().apply { value = "40" }
    val badPoint = MutableLiveData<String>().apply { value = "0" }
    val extensionElevenStatus = MutableLiveData<String>().apply { value = "가온실" }
    val extensionTwelveStatus = MutableLiveData<String>().apply { value = "가온실" }
    val goingOutSaturdayStatus = MutableLiveData<String>().apply { value = "신청" }
    val goingOutSundayStatus = MutableLiveData<String>().apply { value = "신청" }

    override fun apply(event: Lifecycle.Event) {

    }
}
