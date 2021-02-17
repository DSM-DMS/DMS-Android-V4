package com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice

import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Notice
import com.dsm.dms.domain.usecase.GetNoticeListUseCase
import com.dsm.dms.presentation.*
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.RecyclerItem
import com.dsm.dms.presentation.model.NoticeModel
import com.dsm.dms.presentation.model.VisibilityModel
import com.dsm.dms.presentation.model.toModel
import io.reactivex.observers.DisposableSingleObserver


class NoticeListViewModel(
    private val getNoticeListUseCase: GetNoticeListUseCase
): BaseViewModel() {

    val noticeList =
        MutableLiveData<List<RecyclerItem>>().apply {
            value = listOf()
        }
    val visibility =
        MutableLiveData<VisibilityModel>().apply {
            value = VisibilityModel(visibleLoad = View.GONE)
        }

    val backToMyPageEvent = SingleLiveEvent<Unit>()
    val goToDetailEvent = SingleLiveEvent<Pair<View, NoticeModel>>()
    val showMessageEvent = SingleLiveEvent<String>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> {
                getNoticeList()
            }
        }
    }

    fun backClick() = backToMyPageEvent.call()

    private fun getNoticeList() {
        visibility.updateVisibility {
            it.visibleLoad = View.VISIBLE
        }
        getNoticeListUseCase.execute(Unit, object: DisposableSingleObserver<Result<List<Notice>>>() {
            override fun onSuccess(result: Result<List<Notice>>) {
                when(result) {
                    is Result.Success -> onSuccessGetNoticeList(result)
                    is Result.Error -> onErrorGetNoticeList(result)
                }
            }

            override fun onError(e: Throwable) {

            }
        })
    }

    private fun onSuccessGetNoticeList(result: Result.Success<List<Notice>>) {
        visibility.updateVisibility {
            it.visibleLoad = View.GONE
            it.visibleContent = View.VISIBLE
        }
        loadData(result.data.map { it.toModel() })
    }

    private fun onErrorGetNoticeList(result: Result.Error<List<Notice>>) {
        if (result.data.isNotNullOrEmpty())
            onErrorGetNoticeListIsNotNull(result)
        else
            onErrorGetNoticeListIsNull(result)
    }

    private fun onErrorGetNoticeListIsNotNull(result: Result.Error<List<Notice>>) {
        showMessageGetNoticeList(result.message)
        visibility.updateVisibility {
            it.visibleLoad = View.GONE
            it.visibleContent = View.VISIBLE
        }
        loadData(result.data!!.map { it.toModel() })
    }

    private fun onErrorGetNoticeListIsNull(result: Result.Error<List<Notice>>) {
        showMessageGetNoticeList(result.message)
        visibility.updateVisibility {
            it.visibleLoad = View.GONE
            it.visibleError = View.VISIBLE
        }
        showImageGetNoticeList(result.message)
    }

    private fun showImageGetNoticeList(message: Message) {
        when(message) {
            Message.NETWORK_ERROR ->
                visibility.updateVisibility {
                    it.onErrorShow(R.drawable.ic_network_error)
                }
            Message.SERVER_ERROR ->
                visibility.updateVisibility {
                    it.onErrorShow(R.drawable.ic_server_error)
                }
            Message.UNKNOW_ERROR ->
                visibility.updateVisibility {
                    it.onErrorShow(R.drawable.ic_server_error)
                }
            else ->
                visibility.updateVisibility {
                    it.onErrorShow(R.drawable.ic_server_error)
                }
        }
    }

    private fun showMessageGetNoticeList(message: Message) {
        when(message) {
            Message.NETWORK_ERROR ->
                showMessageEvent.value = "네트워크 오류가 발생했습니다"
            Message.SERVER_ERROR ->
                showMessageEvent.value = "서버 오류가 발생했습니다"
            Message.UNKNOW_ERROR ->
                showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
            else ->
                showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
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
