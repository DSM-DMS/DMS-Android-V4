package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.GoingOutInfo
import io.reactivex.Completable
import io.reactivex.Single


interface GoingOutService {

    fun getGoingOutInfo(): Single<Result<List<GoingOutInfo>>>

    fun applyGoingOut(goingOutInfo: GoingOutInfo): Single<Result<Unit>>

    fun updateGoingOutInfo(goingOutInfo: GoingOutInfo): Single<Result<Unit>>

    fun cancelGoingOut(id: Int): Single<Result<Unit>>

}
