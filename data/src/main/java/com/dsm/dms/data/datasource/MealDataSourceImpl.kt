package com.dsm.dms.data.datasource

import com.dsm.dms.data.entity.MealData
import com.dsm.dms.data.local.database.dao.MealDao
import com.dsm.dms.data.local.database.entity.MealEntity
import com.dsm.dms.data.remote.MealApi
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


class MealDataSourceImpl(
    private val api: MealApi,
    private val mealDao: MealDao
): MealDataSource {
    override fun getRemoteMeal(date: String): Single<MealData> =
        api.getMeal(date)

    override fun getLocalMeal(date: String): MealEntity? =
        mealDao.getMealData(date)

    override fun getAllLocalMeal(): List<MealEntity>? =
        mealDao.getAllMealData()

    override fun saveLocalMeal(vararg mealEntity: MealEntity) =
        mealDao.saveMealData(*mealEntity)

    override fun deleteLocalMeal(date: String) =
        mealDao.deleteMealData(date)
}
