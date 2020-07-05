package com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.BR
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.RecyclerItem
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem
import com.dsm.dms.presentation.model.NoticeModel


class NoticeListViewModel: BaseViewModel() {

    val noticeList = MutableLiveData<List<RecyclerItem>>()

    val backToMyPageEvent = SingleLiveEvent<Unit>()
    val goToDetailEvent = SingleLiveEvent<Pair<View, NoticeModel>>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_START -> {
                loadData(
                    arrayListOf(
                        NoticeModel("asd", "ㅁㅇㄹㅇㄴㄹㄴ","324", "2020-06-20", true),
                        NoticeModel("sdfsd", "ㅁㅇㄹㅇㄴㄹㄴ","543", "2020-06-20", true),
                        NoticeModel("sdfsddsf", "ㅁㅇㄹㅇㄴㄹㄴ","0", "2020-06-20", false)
                    )
                )

            }
        }
    }

    fun backClick() = backToMyPageEvent.call()

    private fun loadData(notices: List<NoticeModel>) {
        noticeList.value = notices.map { NoticeItemViewModel(it) }
            .map { it.toRecyclerItem() }
    }

    private fun NoticeItemViewModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.vm,
            layoutId = R.layout.item_notice
        )

    inner class NoticeItemViewModel(val notice: NoticeModel) {
        fun clickNoticeCard(view: View) {
            goToDetailEvent.value = view to notice
        }
    }
}
