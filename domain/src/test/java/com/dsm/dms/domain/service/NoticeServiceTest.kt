package com.dsm.dms.domain.service

import com.dsm.dms.domain.BaseTest
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Notice
import com.dsm.dms.domain.repository.NoticeRepository
import com.dsm.dms.domain.usecase.GetNoticeUseCase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`


class NoticeServiceTest: BaseTest() {

    @Mock
    private lateinit var noticeRepository: NoticeRepository
    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var noticeService: NoticeService

    private lateinit var getNoticeUseCase: GetNoticeUseCase

    @Before
    fun init() {

        noticeService = NoticeServiceImpl(noticeRepository, errorHandler)

        getNoticeUseCase = GetNoticeUseCase(noticeService, CompositeDisposable())

    }

    @Test
    fun `공지사항 리스트 조회 성공`() {

        val noticeList = listOf(
            Notice(
                id = 1,
                date = "2020-08-31",
                title = "안녕하세요",
                content = "제곧내",
                views = 100
            )
        )

        `when`(noticeRepository.getRemoteNotice())
            .thenReturn(
                Single.just(noticeList)
            )

        `when`(noticeRepository.getLocalNotice())
            .thenReturn(noticeList)

        getNoticeUseCase.create(Unit)
            .test().assertValue(
                Result.Success(noticeList)
            )

    }

    @Test
    fun `공지사항 리스트 조회 실패`() {

        val exception = Exception()
        val noticeList = listOf(
            Notice(
                id = 1,
                date = "2020-08-31",
                title = "안녕하세요",
                content = "제곧내",
                views = 100
            )
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(noticeRepository.getRemoteNotice())
            .thenReturn(
                Single.error(exception)
            )

        `when`(noticeRepository.getLocalNotice())
            .thenReturn(noticeList)

        getNoticeUseCase.create(Unit)
            .test().assertValue(
                Result.Error(noticeList, Message.UNKNOW_ERROR)
            )

    }

}
