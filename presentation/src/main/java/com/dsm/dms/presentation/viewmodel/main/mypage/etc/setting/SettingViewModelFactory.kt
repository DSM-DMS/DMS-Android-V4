package com.dsm.dms.presentation.viewmodel.main.mypage.etc.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.base.ResourcesProvider


class SettingViewModelFactory(private val resourcesProvider: ResourcesProvider): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor(ResourcesProvider::class.java).newInstance(resourcesProvider)

}
