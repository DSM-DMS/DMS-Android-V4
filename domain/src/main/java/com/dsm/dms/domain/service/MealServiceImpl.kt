package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.entity.Meal
import com.dsm.dms.domain.repository.MealRepository
import io.reactivex.Single
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.toResult


class MealServiceImpl(
    private val repository: MealRepository,
    private val handler: ErrorHandler
): MealService {

    override fun getMeal(date: String): Single<Result<Meal>> =
        repository.getRemoteMeal(date)
            .toResult(
                handler = handler,
                localData = repository.getLocalMeal(date),
                saveLocalFun = { T -> repository.saveLocalMeal(T) }
            )

}
