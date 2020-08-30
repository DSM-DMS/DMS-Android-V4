package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.GoingOutInfo
import io.reactivex.Completable
import io.reactivex.Single


interface GoingOutRepository {

    fun getRemoteGoingOutInfo(): Single<List<GoingOutInfo>>

    fun getLocalGoingOutInfo(): List<GoingOutInfo>?

    fun postRemoteGoingOutInfo(goingOutInfo: GoingOutInfo): Completable

    fun saveLocalGoingOutInfo(vararg goingOutInfo: GoingOutInfo)

    fun patchGoingOutInfo(goingOutInfo: GoingOutInfo): Completable

    fun deleteRemoteGoingOutInfo(id: Int): Completable

    fun deleteLocalGoingOutInfo(id: Int)

}
