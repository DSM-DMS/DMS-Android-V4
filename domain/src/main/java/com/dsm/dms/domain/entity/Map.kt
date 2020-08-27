package com.dsm.dms.domain.entity

data class Map(
    var id: String,
    var classNum: Int,
    var time: Int,
    var map: List<List<Any>>
)
