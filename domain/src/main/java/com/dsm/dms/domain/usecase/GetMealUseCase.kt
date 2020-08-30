package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.Meal
import io.reactivex.Single
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.service.MealService
import io.reactivex.disposables.CompositeDisposable


class GetMealUseCase(
    private val service: MealService,
    composite: CompositeDisposable
): UseCase<String, Result<Meal>>(composite) {

    override fun create(date: String): Single<Result<Meal>> =
        service.getMeal(date)

}
