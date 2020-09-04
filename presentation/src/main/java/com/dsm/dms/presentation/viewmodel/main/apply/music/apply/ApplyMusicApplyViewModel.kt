package com.dsm.dms.presentation.viewmodel.main.apply.music.apply


import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent


class ApplyMusicApplyViewModel: BaseViewModel() {
    val day = MutableLiveData<String>()
    val musicTitle = MutableLiveData<String>()
    val musicArtist = MutableLiveData<String>()

    val backToDetailListEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun backClick() = backToDetailListEvent.call()

    fun apply() {
        backToDetailListEvent.call()
    }
}
