package com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Notice
import com.dsm.dms.domain.usecase.GetNoticeUseCase
import com.dsm.dms.presentation.BR
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.RecyclerItem
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem
import com.dsm.dms.presentation.model.NoticeModel
import com.dsm.dms.presentation.model.toModel
import io.reactivex.observers.DisposableSingleObserver


class NoticeListViewModel(
    private val getNoticeUseCase: GetNoticeUseCase
): BaseViewModel() {

    val noticeList = MutableLiveData<List<RecyclerItem>>()

    val backToMyPageEvent = SingleLiveEvent<Unit>()
    val goToDetailEvent = SingleLiveEvent<Pair<View, NoticeModel>>()
    val showMessageEvent = SingleLiveEvent<String>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_START -> {
                getNotice()
            }
        }
    }

    fun backClick() = backToMyPageEvent.call()

    private fun getNotice() {
        getNoticeUseCase.execute(Unit, object: DisposableSingleObserver<Result<List<Notice>>>() {
            override fun onSuccess(result: Result<List<Notice>>) {
                when(result) {
                    is Result.Success -> onSuccessGetNotice(result)
                    is Result.Error -> onErrorGetNotice(result)
                }
            }

            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun onSuccessGetNotice(result: Result.Success<List<Notice>>) {
        loadData(result.data.map { it.toModel() })
    }

    private fun onErrorGetNotice(result: Result.Error<List<Notice>>) {
        if (result.data != null) {
            loadData(result.data!!.map { it.toModel() })
        }
        when(result.message) {
            Message.UNKNOW_ERROR -> showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
            Message.NETWORK_ERROR -> showMessageEvent.value = "네트워크 오류가 발생했습니다"
            Message.SERVER_ERROR -> showMessageEvent.value = "서버 오류가 발생했습니다"
            else -> showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

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
