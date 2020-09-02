package com.dsm.dms.domain.service

import com.dsm.dms.domain.BaseTest
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.GoingOutInfo
import com.dsm.dms.domain.entity.enums.GoingOutType
import com.dsm.dms.domain.repository.GoingOutRepository
import com.dsm.dms.domain.usecase.ApplyGoingOutUseCase
import com.dsm.dms.domain.usecase.CancelGoingOutUseCase
import com.dsm.dms.domain.usecase.GetGoingOutInfoUseCase
import com.dsm.dms.domain.usecase.UpdateGoingOutInfoUseCase
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`


class GoingOutServiceTest: BaseTest() {

    @Mock
    private lateinit var goingOutRepository: GoingOutRepository
    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var goingOutService: GoingOutService

    private lateinit var getGoingOutInfoUseCase: GetGoingOutInfoUseCase
    private lateinit var applyGoingOutUseCase: ApplyGoingOutUseCase
    private lateinit var updateGoingOutInfoUseCase: UpdateGoingOutInfoUseCase
    private lateinit var cancelGoingOutUseCase: CancelGoingOutUseCase

    @Before
    fun init() {

        goingOutService = GoingOutServiceImpl(goingOutRepository, errorHandler)

        getGoingOutInfoUseCase = GetGoingOutInfoUseCase(goingOutService, CompositeDisposable())
        applyGoingOutUseCase = ApplyGoingOutUseCase(goingOutService, CompositeDisposable())
        updateGoingOutInfoUseCase = UpdateGoingOutInfoUseCase(goingOutService, CompositeDisposable())
        cancelGoingOutUseCase = CancelGoingOutUseCase(goingOutService, CompositeDisposable())

    }

    @Test
    fun `외출신청 정보 가져오기 성공`() {

        val goingOutInfoList = listOf(
            GoingOutInfo(
                id = 1,
                type = GoingOutType.MEAL_GOING,
                date = "2020-08-31",
                place = "서울"
            )
        )

        `when`(goingOutRepository.getRemoteGoingOutInfo())
            .thenReturn(
                Single.just(goingOutInfoList)
            )

        `when`(goingOutRepository.getLocalGoingOutInfo())
            .thenReturn(
                goingOutInfoList
            )

        getGoingOutInfoUseCase.create(Unit)
            .test().assertValue(
                Result.Success(goingOutInfoList)
            )

    }

    @Test
    fun `외출신청 정보 가져오기 실패`() {

        val exception = Exception()
        val goingOutInfoList = listOf(
            GoingOutInfo(
                id = 1,
                type = GoingOutType.MEAL_GOING,
                date = "2020-08-31",
                place = "서울"
            )
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(goingOutRepository.getRemoteGoingOutInfo())
            .thenReturn(
                Single.error(exception)
            )

        `when`(goingOutRepository.getLocalGoingOutInfo())
            .thenReturn(
                goingOutInfoList
            )

        getGoingOutInfoUseCase.create(Unit)
            .test().assertValue(
                Result.Error(goingOutInfoList, Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `외출신청 하기 성공`() {

        val goingOutInfo = GoingOutInfo(
            id = 1,
            type = GoingOutType.MEAL_GOING,
            date = "2020-08-31",
            place = "서울"
        )

        `when`(goingOutRepository.postRemoteGoingOutInfo(goingOutInfo))
            .thenReturn(
                Completable.complete()
            )

        applyGoingOutUseCase.create(goingOutInfo)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `외출신청 하기 실패`() {

        val exception = Exception()
        val goingOutInfo = GoingOutInfo(
            id = 1,
            type = GoingOutType.MEAL_GOING,
            date = "2020-08-31",
            place = "서울"
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(goingOutRepository.postRemoteGoingOutInfo(goingOutInfo))
            .thenReturn(
                Completable.error(exception)
            )

        applyGoingOutUseCase.create(goingOutInfo)
            .test().assertValue(
                Result.Error(message = Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `외출신청 정보 수정 성공`() {

        val goingOutInfo = GoingOutInfo(
            id = 1,
            type = GoingOutType.MEAL_GOING,
            date = "2020-08-31",
            place = "서울"
        )

        `when`(goingOutRepository.patchGoingOutInfo(goingOutInfo))
            .thenReturn(
                Completable.complete()
            )

        updateGoingOutInfoUseCase.create(goingOutInfo)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `외출신청 정보 수정 실패`() {

        val exception = Exception()
        val goingOutInfo = GoingOutInfo(
            id = 1,
            type = GoingOutType.MEAL_GOING,
            date = "2020-08-31",
            place = "서울"
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(goingOutRepository.patchGoingOutInfo(goingOutInfo))
            .thenReturn(
                Completable.error(exception)
            )

        updateGoingOutInfoUseCase.create(goingOutInfo)
            .test().assertValue(
                Result.Error(message =  Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `외출신청 취소 성공`() {

        val id = 1

        `when`(goingOutRepository.deleteRemoteGoingOutInfo(id))
            .thenReturn(
                Completable.complete()
            )

        cancelGoingOutUseCase.create(id)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `외출신청 취소 실패`() {

        val exception = Exception()
        val id = 1

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(goingOutRepository.deleteRemoteGoingOutInfo(id))
            .thenReturn(
                Completable.error(exception)
            )

        cancelGoingOutUseCase.create(id)
            .test().assertValue(
                Result.Error(message = Message.UNKNOW_ERROR)
            )

    }

}
