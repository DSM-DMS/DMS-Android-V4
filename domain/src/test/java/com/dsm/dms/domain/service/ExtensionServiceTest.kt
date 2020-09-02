package com.dsm.dms.domain.service

import com.dsm.dms.domain.BaseTest
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.entity.Map
import com.dsm.dms.domain.repository.ExtensionRepository
import com.dsm.dms.domain.usecase.CancelExtensionUseCase
import com.dsm.dms.domain.usecase.GetExtensionInfoUseCase
import com.dsm.dms.domain.usecase.GetExtensionMapUseCase
import com.dsm.dms.domain.usecase.ApplyExtensionUseCase
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`


class ExtensionServiceTest: BaseTest() {

    @Mock
    private lateinit var extensionRepository: ExtensionRepository
    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var extensionService: ExtensionService

    private lateinit var getExtensionMapUseCase: GetExtensionMapUseCase
    private lateinit var getExtensionInfoUseCase: GetExtensionInfoUseCase
    private lateinit var applyExtensionUseCase: ApplyExtensionUseCase
    private lateinit var cancelExtensionUseCase: CancelExtensionUseCase

    @Before
    fun init() {

        extensionService = ExtensionServiceImpl(extensionRepository, errorHandler)

        getExtensionMapUseCase = GetExtensionMapUseCase(extensionService, CompositeDisposable())
        getExtensionInfoUseCase = GetExtensionInfoUseCase(extensionService, CompositeDisposable())
        applyExtensionUseCase = ApplyExtensionUseCase(extensionService, CompositeDisposable())
        cancelExtensionUseCase = CancelExtensionUseCase(extensionService, CompositeDisposable())

    }

    @Test
    fun `연장신청 맵 가져오기 성공`() {

        val map = Map(
            time = 12,
            classNum = 3,
            map = emptyList()
        )

        val resultMap = Map(
            time = 12,
            classNum = 3,
            map = listOf(
                listOf(1, "송진우", 3, 4, 5),
                listOf(1, "송진우", 3, 4, 5),
                listOf(1, "송진우", 3, 4, 5)
            )
        )

        `when`(extensionRepository.getRemoteExtensionMap(map.time, map.classNum))
            .thenReturn(
                Single.just(resultMap)
            )

        `when`(extensionRepository.getLocalExtensionMap(map.time, map.classNum))
            .thenReturn(resultMap)

        getExtensionMapUseCase.create(map)
            .test().assertValue(
                Result.Success(resultMap)
            )

    }

    @Test
    fun `연장신청 맵 가져오기 실패`() {

        val exception = Exception()
        val map = Map(
            time = 12,
            classNum = 3,
            map = emptyList()
        )
        val resultMap = Map(
            time = 12,
            classNum = 3,
            map = listOf(
                listOf(1, "송진우", 3, 4, 5),
                listOf(1, "송진우", 3, 4, 5),
                listOf(1, "송진우", 3, 4, 5)
            )
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(extensionRepository.getRemoteExtensionMap(map.time, map.classNum))
            .thenReturn(
                Single.error(exception)
            )

        `when`(extensionRepository.getLocalExtensionMap(map.time, map.classNum))
            .thenReturn(resultMap)

        getExtensionMapUseCase.create(map)
            .test().assertValue(
                Result.Error(resultMap, Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `연장신청 정보 가져오기 성공`() {

        val time = 12
        val extensionInfo = ExtensionInfo(
            time = 12,
            classNumber = 3,
            seatNumber = 14
        )

        `when`(extensionRepository.getRemoteExtensionInfo(time))
            .thenReturn(
                Single.just(extensionInfo)
            )

        `when`(extensionRepository.getLocalExtensionInfo(time))
            .thenReturn(extensionInfo)

        getExtensionInfoUseCase.create(time)
            .test().assertValue(
                Result.Success(extensionInfo)
            )

    }

    @Test
    fun `연장신청 정보 가져오기 실패`() {

        val exception = Exception()
        val time = 12
        val extensionInfo = ExtensionInfo(
            time = 12,
            classNumber = 3,
            seatNumber = 14
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(extensionRepository.getRemoteExtensionInfo(time))
            .thenReturn(
                Single.error(exception)
            )

        `when`(extensionRepository.getLocalExtensionInfo(time))
            .thenReturn(extensionInfo)

        getExtensionInfoUseCase.create(time)
            .test().assertValue(
                Result.Error(extensionInfo, Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `연장신청 하기 성공`() {

        val extensionInfo = ExtensionInfo(
            time = 12,
            classNumber = 3,
            seatNumber = 14
        )

        `when`(extensionRepository.postRemoteExtensionInfo(extensionInfo))
            .thenReturn(
                Completable.complete()
            )

        applyExtensionUseCase.create(extensionInfo)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `연장신청 하기 실패`() {

        val exception = Exception()
        val extensionInfo = ExtensionInfo(
            time = 12,
            classNumber = 3,
            seatNumber = 14
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(extensionRepository.postRemoteExtensionInfo(extensionInfo))
            .thenReturn(
                Completable.error(exception)
            )

        applyExtensionUseCase.create(extensionInfo)
            .test().assertValue(
                Result.Error(message = Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `연장신청 취소 성공`() {

        val time = 12

        `when`(extensionRepository.deleteRemoteExtensionInfo(time))
            .thenReturn(
                Completable.complete()
            )

        cancelExtensionUseCase.create(time)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `연장신청 취소 실패`() {

        val exception = Exception()
        val time = 12

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(extensionRepository.deleteRemoteExtensionInfo(time))
            .thenReturn(
                Completable.error(exception)
            )

        cancelExtensionUseCase.create(time)
            .test().assertValue(
                Result.Error(message =  Message.UNKNOW_ERROR)
            )

    }

}
