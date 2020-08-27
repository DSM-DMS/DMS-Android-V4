package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.response.GetListGoingOutResponse
import com.dsm.dms.data.entity.GoingOutInfoData
import com.dsm.dms.data.local.database.entity.GoingOutInfoEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface GoingOutDataSource {

    fun getRemoteGoingOutInfo(): Single<GetListGoingOutResponse>

    fun getLocalGoingOutInfo(): List<GoingOutInfoEntity>?

    fun postRemoteGoingOutInfo(goingOutInfoData: GoingOutInfoData): Completable

    fun saveLocalGoingOutInfo(vararg goingOutInfoEntity: GoingOutInfoEntity)

    fun patchGoingOutInfo(goingOutInfoData: GoingOutInfoData): Completable

    fun deleteRemoteGoingOutInfo(id: Int): Completable

    fun deleteLocalGoingOutInfo(id: Int)

}
