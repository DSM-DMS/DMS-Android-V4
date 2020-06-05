package com.dsm.dms.presentation.viewmodel.main.apply.music.detail


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ApplyMusicDayDetailListViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()
}
