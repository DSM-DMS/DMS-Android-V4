package com.dsm.dms.presentation

import com.dsm.dms.presentation.base.BaseViewModel
import org.junit.After

abstract class BaseViewModelTest {

    lateinit var viewModel: BaseViewModel

    abstract fun setUp()

    abstract fun teardown()
}