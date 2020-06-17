package com.dsm.dms.presentation.viewmodel.main.mypage.etc.bug

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class BugReportViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()

}
