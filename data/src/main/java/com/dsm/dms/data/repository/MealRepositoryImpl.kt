package com.dsm.dms.data.repository

import com.dsm.dms.data.datasource.MealDataSource
import com.dsm.dms.data.entity.toDbEntity
import com.dsm.dms.data.entity.toEntity
import com.dsm.dms.domain.entity.Meal
import com.dsm.dms.domain.repository.MealRepository
import io.reactivex.Single


class MealRepositoryImpl(
    private val dataSource: MealDataSource
): MealRepository {

    override fun getRemoteMeal(date: String): Single<Meal> =
        dataSource.getRemoteMeal(date).map {
            it.breakfast.isNullOrEmpty()
            it.toEntity(date)
        }

    override fun getLocalMeal(date: String): Meal? =
        dataSource.getLocalMeal(date)?.toEntity()

    override fun saveLocalMeal(vararg meal: Meal) =
        dataSource.saveLocalMeal(
            *meal.map {
                it.toDbEntity()
            }.toTypedArray()
        )

    override fun deleteLocalMeal(date: String) =
        dataSource.deleteLocalMeal(date)

}
