package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.Meal
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface MealRepository {

    fun getRemoteMeal(date: String): Single<Meal>

    fun getLocalMeal(date: String): Meal?

    fun getAllLocalMeal(): List<Meal>?

    fun saveLocalMeal(vararg meal: Meal)

    fun deleteLocalMeal(date: String)

}
