package com.dsm.dms.domain.service

import com.dsm.dms.domain.BaseTest
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Point
import com.dsm.dms.domain.repository.PointNoticeRepository
import com.dsm.dms.domain.usecase.GetPointNoticeUseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`


class PointNoticeServiceTest: BaseTest() {

    @Mock
    private lateinit var pointNoticeRepository: PointNoticeRepository
    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var pointNoticeService: PointNoticeService

    private lateinit var getPointNoticeUseCase: GetPointNoticeUseCase

    @Before
    fun init() {

        pointNoticeService = PointNoticeServiceImpl(pointNoticeRepository, errorHandler)

        getPointNoticeUseCase = GetPointNoticeUseCase(pointNoticeService, CompositeDisposable())

    }

    @Test
    fun `벌점항목 리스트 조회 성공`() {

        val pointNoticeList = listOf(
            Point(
                name = "라면 먹기",
                point = -3
            )
        )

        `when`(pointNoticeRepository.getRemotePointNotice())
            .thenReturn(
                Single.just(pointNoticeList)
            )

        `when`(pointNoticeRepository.getLocalPointNotice())
            .thenReturn(pointNoticeList)

        getPointNoticeUseCase.create(Unit)
            .test().assertValue(
                Result.Success(pointNoticeList)
            )

    }

    @Test
    fun `벌점항목 리스트 조회 실패`() {

        val exception = Exception()
        val pointNoticeList = listOf(
            Point(
                name = "라면 먹기",
                point = -3
            )
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(pointNoticeRepository.getRemotePointNotice())
            .thenReturn(
                Single.error(exception)
            )

        `when`(pointNoticeRepository.getLocalPointNotice())
            .thenReturn(pointNoticeList)

        getPointNoticeUseCase.create(Unit)
            .test().assertValue(
                Result.Error(pointNoticeList, Message.UNKNOW_ERROR)
            )

    }

}
