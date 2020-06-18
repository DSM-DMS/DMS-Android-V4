package com.dsm.dms.presentation.viewmodel.main.apply.music.detail

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.BR
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.RecyclerItem
import com.dsm.dms.presentation.model.MusicModel


class ApplyMusicDayDetailListViewModel: BaseViewModel() {
    val listItem = MutableLiveData<List<RecyclerItem>>()
    val day = MutableLiveData<String>()

    val setTitleEvent = SingleLiveEvent<String>()
    val backToListEvent = SingleLiveEvent<Unit>()
    val goToApplyEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_START -> {
                setTitle()
                loadData(
                    arrayListOf(
                        MusicModel("asd", "asd", "Asd"),
                        MusicModel("요청", "요일당 3곡까지 신청 가능합니다", "")
                    )
                )

            }
        }
    }

    fun backClick() = backToListEvent.call()

    private fun setTitle() {
        setTitleEvent.value =
            when(day.value) {
                "monday" -> {
                    "월요일 기상음악"
                }
                "tuesday" -> {
                    "화요일 기상음악"
                }
                "wednesday" -> {
                    "수요일 기상음악"
                }
                "thursday" -> {
                    "목요일 기상음악"
                }
                "friday" -> {
                    "금요일 기상음악"
                }
                else -> {
                    "다시 시도해주세요"
                }
            }
    }

    private fun loadData(music: ArrayList<MusicModel>) {
        listItem.value = music.map { MusicItemViewModel(it) }
            .map { it.toRecyclerItem() }
    }

    private fun MusicItemViewModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.vm,
            layoutId = R.layout.item_music
        )

    inner class MusicItemViewModel(val music: MusicModel) {
        fun cardClick() {
            if (music.applicant.isBlank())
                this@ApplyMusicDayDetailListViewModel.goToApplyEvent.call()
        }
    }
}
