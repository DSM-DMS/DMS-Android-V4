package com.dsm.dms.data.datasource

import com.dsm.dms.data.entity.ExtensionInfoData
import com.dsm.dms.data.entity.MapData
import com.dsm.dms.data.local.database.dao.ExtensionInfoDao
import com.dsm.dms.data.local.database.dao.MapDao
import com.dsm.dms.data.local.database.entity.ExtensionInfoEntity
import com.dsm.dms.data.local.database.entity.MapEntity
import com.dsm.dms.data.remote.ApplyApi
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


class ExtensionDataSourceImpl(
    private val api: ApplyApi,
    private val extensionInfoDao: ExtensionInfoDao,
    private val mapDao: MapDao
): ExtensionDataSource {

    override fun getRemoteExtensionMap(time: Int, classNum: Int): Single<MapData> =
        api.getExtensionStudyMap(time, classNum)

    override fun getLocalExtensionMap(id: String): MapEntity? =
        mapDao.getMapData(id)

    override fun saveLocalExtensionMap(vararg mapEntity: MapEntity) =
        mapDao.saveMapData(*mapEntity)

    override fun deleteLocalExtensionMap(id: String) =
        mapDao.deleteMapData(id)

    override fun getRemoteExtensionInfo(time: Int): Single<ExtensionInfoData> =
        api.getExtensionStudy(time)

    override fun postRemoteExtensionInfo(extensionInfoData: ExtensionInfoData): Completable =
        api.postExtensionStudy(extensionInfoData)

    override fun deleteRemoteExtensionInfo(time: Int): Completable =
        api.deleteExtensionStudy(time)

    override fun getLocalExtensionInfo(time: Int): ExtensionInfoEntity? =
        extensionInfoDao.getExtensionInfoDataFromTime(time)

    override fun saveLocalExtensionInfo(vararg extensionInfoEntity: ExtensionInfoEntity) =
        extensionInfoDao.saveExtensionInfoData(*extensionInfoEntity)

    override fun deleteLocalExtensionInfo(time: Int) =
        extensionInfoDao.deleteExtensionInfoDataFromTime(time)

    override fun getLocalAllExtensionInfo(): List<ExtensionInfoEntity>? =
        extensionInfoDao.getAllExtensionInfoData()

}
