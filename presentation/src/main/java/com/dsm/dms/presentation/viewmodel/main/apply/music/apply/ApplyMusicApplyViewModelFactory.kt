package com.dsm.dms.presentation.viewmodel.main.apply.music.apply


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ApplyMusicApplyViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = modelClass.getConstructor().newInstance()
}
