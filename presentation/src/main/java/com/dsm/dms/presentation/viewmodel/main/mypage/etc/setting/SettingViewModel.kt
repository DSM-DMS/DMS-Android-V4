package com.dsm.dms.presentation.viewmodel.main.mypage.etc.setting

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.BR
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.ResourcesProvider
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.RecyclerItem
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem
import com.dsm.dms.presentation.model.SettingModel


class SettingViewModel(private val resourcesProvider: ResourcesProvider): BaseViewModel() {

    val settingList = MutableLiveData<List<RecyclerItem>>()

    val backToMyPageEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_START -> {
                setSettingList()
            }
        }
    }

    fun clickClose() = backToMyPageEvent.call()

    private fun setSettingList() {
        loadData(
            arrayListOf(
                SettingModel(
                    resourcesProvider.getString(R.string.mypage_setting_dark_mode_title),
                    resourcesProvider.getString(R.string.mypage_setting_dark_mode_content)
                ),
                SettingModel(
                    resourcesProvider.getString(R.string.mypage_setting_extension_alert_title),
                    resourcesProvider.getString(R.string.mypage_setting_extension_alert_content)
                ),
                SettingModel(
                    resourcesProvider.getString(R.string.mypage_setting_staying_alert_title),
                    resourcesProvider.getString(R.string.mypage_setting_staying_alert_content)
                ),
                SettingModel(
                    resourcesProvider.getString(R.string.mypage_setting_notice_alert_title),
                    resourcesProvider.getString(R.string.mypage_setting_notice_alert_content)
                )
            )
        )
    }

    private fun loadData(settings: List<SettingModel>) {
        settingList.value = settings.map { SettingItemViewModel(it) }
            .map { it.toRecyclerItem() }
    }

    private fun SettingItemViewModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.vm,
            layoutId = R.layout.item_setting
        )

    inner class SettingItemViewModel(val setting: SettingModel) {
        fun clickSwitch() {
            setting.checked = !setting.checked
        }
    }
}
