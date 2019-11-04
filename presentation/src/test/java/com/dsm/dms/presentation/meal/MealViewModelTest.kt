package com.dsm.dms.presentation.meal

import com.dsm.dms.presentation.BaseViewModelTest
import com.dsm.dms.presentation.viewmodel.main.meal.MealViewModel
import org.junit.After
import org.junit.Before

class MealViewModelTest: BaseViewModelTest() {

    @Throws(Exception::class)
    @Before
    override fun setUp() {
        viewModel = MealViewModel()
    }

    @Throws(Exception::class)
    @After
    override fun teardown() {

    }
}
