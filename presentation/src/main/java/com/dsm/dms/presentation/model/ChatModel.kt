package com.dsm.dms.presentation.model

data class ChatModel(
    val message: String = "",
    val date: String = "",
    val time: String = "",
    val isViewed: Boolean = false,
    val type: ChatType
) {
    enum class ChatType(value: Int) {
        SEND(0), RECEIVE(1), HEADER(2)
    }
}