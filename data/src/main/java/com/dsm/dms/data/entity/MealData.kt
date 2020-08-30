package com.dsm.dms.data.entity

import com.dsm.dms.data.local.database.entity.MealEntity
import com.dsm.dms.domain.entity.Meal


data class MealData(
    var date: String,
    var breakfast: List<String>,
    var lunch: List<String>,
    var dinner: List<String>
)

fun MealData.toEntity(date: String) =
    Meal(
        date = date,
        breakfast = breakfast,
        lunch = lunch,
        dinner = dinner
    )

fun Meal.toDataEntity() =
    MealData(
        date = date,
        breakfast = breakfast,
        lunch = lunch,
        dinner = dinner
    )

fun Meal.toDbEntity() =
    MealEntity(
        date = date,
        breakfast = breakfast,
        lunch = lunch,
        dinner = dinner
    )

fun MealEntity.toEntity() =
    Meal(
        date = date,
        breakfast = breakfast,
        lunch = lunch,
        dinner = dinner
    )
