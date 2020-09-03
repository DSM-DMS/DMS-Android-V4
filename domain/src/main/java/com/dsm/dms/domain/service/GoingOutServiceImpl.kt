package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.GoingOutInfo
import com.dsm.dms.domain.repository.GoingOutRepository
import com.dsm.dms.domain.toResult
import com.dsm.dms.domain.toSingleResult
import io.reactivex.Completable
import io.reactivex.Single

class GoingOutServiceImpl(
    private val repository: GoingOutRepository,
    private val handler: ErrorHandler
): GoingOutService {

    override fun getGoingOutInfo(): Single<Result<List<GoingOutInfo>>> =
        repository.getRemoteGoingOutInfo()
            .toResult(
                handler = handler,
                getLocalDataFun = { repository.getLocalGoingOutInfo() },
                saveLocalFun = { T -> repository.saveLocalGoingOutInfo(*T.toTypedArray()) }
            )

    override fun postGoingOutInfo(goingOutInfo: GoingOutInfo): Single<Result<Unit>> =
        repository.postRemoteGoingOutInfo(goingOutInfo)
            .toSingleResult(
                handler = handler,
                data = goingOutInfo,
                localFun = { T -> repository.saveLocalGoingOutInfo(T) }
            )


    override fun updateGoingOutInfo(goingOutInfo: GoingOutInfo): Single<Result<Unit>> =
        repository.patchGoingOutInfo(goingOutInfo)
            .toSingleResult(
                handler = handler,
                data = goingOutInfo,
                localFun = { T -> repository.saveLocalGoingOutInfo(T) }
            )

    override fun deleteGoingOutInfo(id: Int): Single<Result<Unit>> =
        repository.deleteRemoteGoingOutInfo(id)
            .toSingleResult(
                handler = handler,
                data = id,
                localFun = { T -> repository.deleteLocalGoingOutInfo(T) }
            )

}
