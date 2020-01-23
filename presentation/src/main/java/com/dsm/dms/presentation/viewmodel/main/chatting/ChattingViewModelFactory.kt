package com.dsm.dms.presentation.viewmodel.main.chatting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ChattingViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()

}