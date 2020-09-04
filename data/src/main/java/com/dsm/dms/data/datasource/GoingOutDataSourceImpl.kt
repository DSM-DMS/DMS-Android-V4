package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.response.GetListGoingOutResponse
import com.dsm.dms.data.entity.GoingOutInfoData
import com.dsm.dms.data.local.database.dao.GoingOutInfoDao
import com.dsm.dms.data.local.database.entity.GoingOutInfoEntity
import com.dsm.dms.data.remote.ApplyApi
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


class GoingOutDataSourceImpl(
    private val api: ApplyApi,
    private val goingOutInfoDao: GoingOutInfoDao
): GoingOutDataSource {

    override fun getRemoteGoingOutInfo(): Single<GetListGoingOutResponse> =
        api.getGoingOut()

    override fun getLocalGoingOutInfo(): List<GoingOutInfoEntity>? =
        goingOutInfoDao.getAllGoingOutInfoData()

    override fun postRemoteGoingOutInfo(goingOutInfoData: GoingOutInfoData): Completable =
        api.postGoingOut(goingOutInfoData)

    override fun saveLocalGoingOutInfo(vararg goingOutInfoEntity: GoingOutInfoEntity) =
        goingOutInfoDao.saveGoingOutInfoData(*goingOutInfoEntity)

    override fun patchGoingOutInfo(goingOutInfoData: GoingOutInfoData): Completable =
        api.patchGoingOut(goingOutInfoData.id, goingOutInfoData)

    override fun deleteRemoteGoingOutInfo(id: Int): Completable =
        api.deleteGoingOut(id)

    override fun deleteLocalGoingOutInfo(id: Int) =
        goingOutInfoDao.deleteGoingOutInfoDataFromId(id)

}
