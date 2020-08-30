package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Point
import com.dsm.dms.domain.repository.PointNoticeRepository
import com.dsm.dms.domain.toResult
import io.reactivex.Single


class PointNoticeServiceImpl(
    private val repository: PointNoticeRepository,
    private val handler: ErrorHandler
): PointNoticeService {

    override fun getPointNotice(): Single<Result<List<Point>>> =
        repository.getRemotePointNotice()
            .toResult(
                handler = handler,
                localData = repository.getLocalPointNotice(),
                saveLocalFun = { T -> repository.saveLocalPointNotice(*T.toTypedArray()) }
            )

}
