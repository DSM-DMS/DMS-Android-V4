package com.dsm.dms.domain.entity


data class Meal(
    var date: String = "",
    var breakfast: List<String> = emptyList(),
    var lunch: List<String> = emptyList(),
    var dinner: List<String> = emptyList()
)
