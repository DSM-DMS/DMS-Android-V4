package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.enums.StayInfo
import com.dsm.dms.domain.repository.StayRepository
import com.dsm.dms.domain.toResult
import com.dsm.dms.domain.toSingleResult
import io.reactivex.Single


class StayServiceImpl(
    private val repository: StayRepository,
    private val handler: ErrorHandler
): StayService {

    override fun getStayInfo(): Single<Result<StayInfo>> =
        repository.getRemoteStayInfo()
            .toResult(
                handler = handler,
                getLocalDataFun = { repository.getLocalStayInfo() },
                saveLocalFun = { T -> repository.saveLocalStayInfo(T) }
            )

    override fun applyStay(stayInfo: StayInfo): Single<Result<Unit>> =
        repository.postRemoteStayInfo(stayInfo)
            .toSingleResult(
                handler = handler,
                data = stayInfo,
                localFun = { T -> repository.saveLocalStayInfo(T) }
            )
}
