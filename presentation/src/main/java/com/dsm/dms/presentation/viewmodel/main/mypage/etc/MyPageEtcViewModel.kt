package com.dsm.dms.presentation.viewmodel.main.mypage.etc

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem


class MyPageEtcViewModel: BaseViewModel() {

    val goChangePasswordEvent = SingleLiveEvent<Unit>()
    val goBugReportEvent = SingleLiveEvent<Unit>()
    val goPointEvent = SingleLiveEvent<Unit>()
    val goNoticeEvent = SingleLiveEvent<Unit>()
    val goSettingEvent = SingleLiveEvent<Unit>()

    val createLogoutDialogEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun clickChangePassword() = goChangePasswordEvent.call()

    fun clickBugReport() = goBugReportEvent.call()

    fun clickPoint() = goPointEvent.call()

    fun clickLogout() = createLogoutDialogEvent.call()

    fun clickNotice() = goNoticeEvent.call()

    fun clickSetting() = goSettingEvent.call()

}
