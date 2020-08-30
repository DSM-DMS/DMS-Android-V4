package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Notice
import com.dsm.dms.domain.entity.Point
import com.dsm.dms.domain.repository.NoticeRepository
import com.dsm.dms.domain.toResult
import io.reactivex.Single


class NoticeServiceImpl(
    private val repository: NoticeRepository,
    private val handler: ErrorHandler
): NoticeService {

    override fun getNotice(): Single<Result<List<Notice>>> =
        repository.getRemoteNotice()
            .toResult(
                handler = handler,
                localData = repository.getLocalNotice(),
                saveLocalFun = { T -> repository.saveLocalNotice(*T.toTypedArray()) }
            )

    override fun getPointNotice(): Single<Result<List<Point>>> =
        repository.getRemotePointNotice()
            .toResult(
                handler = handler,
                localData = repository.getLocalPointNotice(),
                saveLocalFun = { T -> repository.saveLocalPointNotice(*T.toTypedArray()) }
            )

}
