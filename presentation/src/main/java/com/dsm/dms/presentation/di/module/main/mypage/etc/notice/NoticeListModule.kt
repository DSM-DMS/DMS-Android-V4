package com.dsm.dms.presentation.di.module.main.mypage.etc.notice

import com.dsm.dms.data.datasource.NoticeDataSource
import com.dsm.dms.data.datasource.NoticeDataSourceImpl
import com.dsm.dms.data.local.database.dao.NoticeDao
import com.dsm.dms.data.remote.BaseApi
import com.dsm.dms.data.repository.NoticeRepositoryImpl
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.repository.NoticeRepository
import com.dsm.dms.domain.service.NoticeService
import com.dsm.dms.domain.service.NoticeServiceImpl
import com.dsm.dms.domain.usecase.GetNoticeListUseCase
import com.dsm.dms.presentation.di.scope.MyPageFragmentScope
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice.NoticeListViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class NoticeListModule {

    @MyPageFragmentScope
    @Provides
    fun provideViewModelFactory(
        getNoticeListUseCase: GetNoticeListUseCase
    ): NoticeListViewModelFactory =
        NoticeListViewModelFactory(getNoticeListUseCase)

    @MyPageFragmentScope
    @Provides
    fun provideGetNoticeListUseCase(
        noticeService: NoticeService,
        composite: CompositeDisposable
    ): GetNoticeListUseCase =
        GetNoticeListUseCase(noticeService, composite)

    @MyPageFragmentScope
    @Provides
    fun provideNoticeService(
        noticeRepository: NoticeRepository,
        handler: ErrorHandler
    ): NoticeService =
        NoticeServiceImpl(noticeRepository, handler)

    @MyPageFragmentScope
    @Provides
    fun provideNoticeRepository(
        noticeDataSource: NoticeDataSource
    ): NoticeRepository =
        NoticeRepositoryImpl(noticeDataSource)

    @MyPageFragmentScope
    @Provides
    fun provideNoticeDataSource(
        baseApi: BaseApi,
        noticeDao: NoticeDao
    ): NoticeDataSource =
        NoticeDataSourceImpl(baseApi, noticeDao)

}
