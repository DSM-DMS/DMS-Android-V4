package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Meal
import io.reactivex.Single


interface MealService {

    fun getMeal(date: String): Single<Result<Meal>>

}
