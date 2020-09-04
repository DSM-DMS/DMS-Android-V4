package com.dsm.dms.presentation.model

import com.dsm.dms.domain.entity.Meal


data class MealModel(
    var date: String = "",
    var breakfast: String = "",
    var lunch: String = "",
    var dinner: String = ""
)

fun Meal.toModel(): MealModel {

    val meal = MealModel(
        date = date,
        breakfast = breakfast.mealListToString(),
        lunch = lunch.mealListToString(),
        dinner = dinner.mealListToString()
    )

    return meal
}

fun List<String>.mealListToString(): String =
    if (isNotEmpty())
        joinToString(", ")
    else "급식이 없습니다."
