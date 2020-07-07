package com.dsm.dms.presentation.viewmodel.main.chatting

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.BR
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.RecyclerItem
import com.dsm.dms.presentation.model.ChatModel


class ChattingViewModel: BaseViewModel() {
    val chatList = MutableLiveData<ArrayList<RecyclerItem>>()
    val sendBoxMessage = MutableLiveData<String>()

    val updateChatDataEvent = SingleLiveEvent<List<RecyclerItem>>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_START -> {
                loadData(
                    arrayListOf(
                        ChatModel(date = "8월 4일 일요일", type = ChatModel.ChatType.HEADER),
                        ChatModel(message = "안녕 지혁아", time = "13:14", isViewed = true, type = ChatModel.ChatType.SEND),
                        ChatModel(message = "안녕 진우야", time = "13:15", isViewed = true, type = ChatModel.ChatType.RECEIVE),
                        ChatModel(message = "뭘 안녕이야 ㅋㅋㅋㅋ", time = "13:16", type = ChatModel.ChatType.SEND)
                    )
                )
            }
        }
    }

    fun clickSend() {
        sendBoxMessage.value?.let {
            addData(
                arrayListOf(
                    ChatModel(message = it, time = "13:17", type = ChatModel.ChatType.SEND)
                )
            )
        }
    }

    private fun loadData(chat: ArrayList<ChatModel>) {
        chatList.value = ArrayList(
            chat.toRecyclerItemList()
        )
    }

    private fun addData(chat: ArrayList<ChatModel>) {
        val recyclerItems =  chat.toRecyclerItemList()
        chatList.value!!.addAll(recyclerItems)
        updateChatDataEvent.value = recyclerItems
    }

    private fun ArrayList<ChatModel>.toRecyclerItemList() =
        map { it.toViewModel() }

    private fun ChatModel.toViewModel() = ChatItemViewModel(this).sectionItem()

    private fun ChatItemViewModel.sectionItem() =
        when(chat.type) {
            ChatModel.ChatType.SEND -> toSendRecyclerItem()
            ChatModel.ChatType.RECEIVE -> toReceiveRecyclerItem()
            ChatModel.ChatType.HEADER -> toHeaderRecyclerItem()
        }

    private fun ChatItemViewModel.toSendRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.vm,
            layoutId = R.layout.item_send_chat
        )

    private fun ChatItemViewModel.toReceiveRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.vm,
            layoutId = R.layout.item_receive_chat
        )

    private fun ChatItemViewModel.toHeaderRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.vm,
            layoutId = R.layout.item_header_chat
        )
}

class ChatItemViewModel(val chat: ChatModel)
