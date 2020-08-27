package com.dsm.dms.data.datasource

import com.dsm.dms.data.entity.MealData
import com.dsm.dms.data.local.database.entity.MealEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface MealDataSource {

    fun getRemoteMeal(date: String): Single<MealData>

    fun getLocalMeal(date: String): MealEntity?

    fun saveLocalMeal(vararg mealEntity: MealEntity)

    fun deleteLocalMeal(date: String)

}