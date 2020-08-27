package com.dsm.dms.domain.service

import com.dsm.dms.domain.BaseTest
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.entity.Meal
import com.dsm.dms.domain.repository.MealRepository
import com.dsm.dms.domain.usecase.GetMealUseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import com.dsm.dms.domain.base.Result
import io.reactivex.Maybe


class MealServiceTest: BaseTest() {

    @Mock
    private lateinit var mealRepository: MealRepository
    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var mealService: MealService

    private lateinit var getMealUseCase: GetMealUseCase

    @Before
    fun init() {
        mealService = MealServiceImpl(mealRepository, errorHandler)

        getMealUseCase = GetMealUseCase(mealService, CompositeDisposable())
    }

    @Test
    fun `급식 가져오기 성공 테스트`() {
        val date = "2020-08-04"
        val meal = Meal("", listOf("김치"), listOf("김치"), listOf("김치"))

        `when`(mealRepository.getLocalMeal(date))
            .thenReturn(Maybe.just(meal))

        `when`(mealRepository.getRemoteMeal(date))
            .thenReturn(Single.just(meal))

        getMealUseCase.create(date)
            .test().assertValue(
                Result.Success(meal)
            )
    }

    @Test
    fun `급식 가져오기 실패 테스트`() {
        val exception = Exception()
        val date = "2020-08-04"
        val meal = Meal("", listOf("김치"), listOf("김치"), listOf("김치"))

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(mealRepository.getLocalMeal(date))
            .thenReturn(Maybe.just(meal))

        `when`(mealRepository.getRemoteMeal(date))
            .thenReturn(Single.error(exception))

        getMealUseCase.create(date)
            .test().assertValue(
                Result.Error(meal, Message.UNKNOW_ERROR)
            )
    }

}
