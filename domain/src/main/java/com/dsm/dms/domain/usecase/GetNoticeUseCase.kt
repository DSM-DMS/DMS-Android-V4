package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.Notice
import com.dsm.dms.domain.service.NoticeService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class GetNoticeUseCase(
    private val service: NoticeService,
    composite: CompositeDisposable
): UseCase<Unit, Result<List<Notice>>>(composite) {

    override fun create(data: Unit): Single<Result<List<Notice>>>  =
        service.getNotice()

}
