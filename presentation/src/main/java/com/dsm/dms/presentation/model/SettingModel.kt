package com.dsm.dms.presentation.model

data class SettingModel(
    val title: String,
    val content: String,
    var checked: Boolean = false
)
