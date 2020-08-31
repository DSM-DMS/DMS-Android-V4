package com.dsm.dms.domain.service

import com.dsm.dms.domain.BaseTest
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Schedule
import com.dsm.dms.domain.repository.ScheduleRepository
import com.dsm.dms.domain.usecase.GetScheduleUseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`


class ScheduleServiceTest: BaseTest() {

    @Mock
    private lateinit var scheduleRepository: ScheduleRepository
    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var scheduleService: ScheduleService

    private lateinit var getScheduleUseCase: GetScheduleUseCase

    @Before
    fun init() {

        scheduleService = ScheduleServiceImpl(scheduleRepository, errorHandler)

        getScheduleUseCase = GetScheduleUseCase(scheduleService, CompositeDisposable())

    }

    @Test
    fun `학사일정 리스트 조회 성공`() {

        val scheduleList = listOf(
            Schedule(
                id = 1,
                name = "전체 조회",
                time = "11시",
                place = "새롬홀"
            )
        )
        val date = "2020-08-31"

        `when`(scheduleRepository.getRemoteSchedule(date))
            .thenReturn(
                Single.just(scheduleList)
            )

        `when`(scheduleRepository.getLocalSchedule(date))
            .thenReturn(scheduleList)

        getScheduleUseCase.create(date)
            .test().assertValue(
                Result.Success(scheduleList)
            )

    }

    @Test
    fun `학사일정 리스트 조회 실패`() {

        val exception = Exception()
        val scheduleList = listOf(
            Schedule(
                id = 1,
                name = "전체 조회",
                time = "11시",
                place = "새롬홀"
            )
        )
        val date = "2020-08-31"

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(scheduleRepository.getRemoteSchedule(date))
            .thenReturn(
                Single.error(exception)
            )

        `when`(scheduleRepository.getLocalSchedule(date))
            .thenReturn(scheduleList)

        getScheduleUseCase.create(date)
            .test().assertValue(
                Result.Error(scheduleList, Message.UNKNOW_ERROR)
            )

    }

}
