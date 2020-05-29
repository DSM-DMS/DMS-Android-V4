package com.dsm.dms.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dsm.dms.presentation.RxSchedulerRule
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.mockito.MockitoAnnotations

open class BaseViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxSchedulerRule()
    }

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
    }
}