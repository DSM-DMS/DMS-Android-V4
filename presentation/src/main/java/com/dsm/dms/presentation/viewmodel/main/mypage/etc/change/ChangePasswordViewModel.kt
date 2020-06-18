package com.dsm.dms.presentation.viewmodel.main.mypage.etc.change

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem


class ChangePasswordViewModel: BaseViewModel() {

    val originPassword = MutableLiveData<String>()
    val newPassword = MutableLiveData<String>()
    val newPasswordCheck = MutableLiveData<String>()

    val backToMyPageEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun backClick() = backToMyPageEvent.call()

    fun clickChange() {
        backToMyPageEvent.call()
    }

}
