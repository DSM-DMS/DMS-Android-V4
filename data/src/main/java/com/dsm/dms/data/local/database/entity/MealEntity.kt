package com.dsm.dms.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MealEntity(
    @PrimaryKey
    var date: String,
    var breakfast: List<String>,
    var lunch: List<String>,
    var dinner: List<String>
)
