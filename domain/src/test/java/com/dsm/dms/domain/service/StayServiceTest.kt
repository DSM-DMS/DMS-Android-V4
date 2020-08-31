package com.dsm.dms.domain.service

import com.dsm.dms.domain.BaseTest
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.enums.StayInfo
import com.dsm.dms.domain.repository.StayRepository
import com.dsm.dms.domain.usecase.ApplyStayUseCase
import com.dsm.dms.domain.usecase.GetStayInfoUseCase
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`


class StayServiceTest: BaseTest() {

    @Mock
    private lateinit var stayRepository: StayRepository
    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var stayService: StayService

    private lateinit var getStayInfoUseCase: GetStayInfoUseCase
    private lateinit var applyStayUseCase: ApplyStayUseCase

    @Before
    fun init() {

        stayService = StayServiceImpl(stayRepository, errorHandler)

        getStayInfoUseCase = GetStayInfoUseCase(stayService, CompositeDisposable())
        applyStayUseCase = ApplyStayUseCase(stayService, CompositeDisposable())

    }

    @Test
    fun `잔류신청 조회 성공`() {

        val stayInfo = StayInfo.STAY

        `when`(stayRepository.getRemoteStayInfo())
            .thenReturn(
                Single.just(stayInfo)
            )

        `when`(stayRepository.getLocalStayInfo())
            .thenReturn(stayInfo)

        getStayInfoUseCase.create(Unit)
            .test().assertValue(
                Result.Success(stayInfo)
            )

    }

    @Test
    fun `잔류신청 조회 실패`() {

        val exception = Exception()
        val stayInfo = StayInfo.STAY

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(stayRepository.getRemoteStayInfo())
            .thenReturn(
                Single.error(exception)
            )

        `when`(stayRepository.getLocalStayInfo())
            .thenReturn(stayInfo)

        getStayInfoUseCase.create(Unit)
            .test().assertValue(
                Result.Error(stayInfo, Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `잔류신청 하기 성공`() {

        val stayInfo = StayInfo.STAY

        `when`(stayRepository.postRemoteStayInfo(stayInfo))
            .thenReturn(
                Completable.complete()
            )

        applyStayUseCase.create(stayInfo)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `잔류신청 하기 실패`() {

        val exception = Exception()
        val stayInfo = StayInfo.STAY

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(stayRepository.postRemoteStayInfo(stayInfo))
            .thenReturn(
                Completable.error(exception)
            )

        applyStayUseCase.create(stayInfo)
            .test().assertValue(
                Result.Error(Unit, Message.UNKNOW_ERROR)
            )

    }

}
