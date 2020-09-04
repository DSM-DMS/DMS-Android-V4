package com.dsm.dms.data.datasource

import com.dsm.dms.data.entity.ExtensionInfoData
import com.dsm.dms.data.entity.MapData
import com.dsm.dms.data.local.database.entity.ExtensionInfoEntity
import com.dsm.dms.data.local.database.entity.MapEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface ExtensionDataSource {
    fun getRemoteExtensionMap(time: Int, classNum: Int): Single<MapData>

    fun getLocalExtensionMap(time: Int, classNum: Int): MapEntity?

    fun saveLocalExtensionMap(vararg mapEntity: MapEntity)

    fun deleteLocalExtensionMap(time: Int, classNum: Int)

    fun getRemoteExtensionInfo(time: Int): Single<ExtensionInfoData>

    fun getLocalExtensionInfo(time: Int): ExtensionInfoEntity?

    fun postRemoteExtensionInfo(extensionInfoData: ExtensionInfoData): Completable

    fun deleteRemoteExtensionInfo(time: Int): Completable

    fun saveLocalExtensionInfo(vararg extensionInfoEntity: ExtensionInfoEntity)

    fun deleteLocalExtensionInfo(time: Int)

    fun getLocalAllExtensionInfo(): List<ExtensionInfoEntity>?

}
