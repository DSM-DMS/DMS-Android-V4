package com.dsm.dms.data.datasource

import com.dsm.dms.data.`object`.RoomData
import com.dsm.dms.data.entity.ExtensionInfoData
import com.dsm.dms.data.entity.MapData
import com.dsm.dms.data.local.database.entity.ExtensionInfoEntity
import com.dsm.dms.data.local.database.entity.MapEntity
import com.dsm.dms.domain.`object`.Room
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface ExtensionDataSource {
    fun getRemoteExtensionMap(room: RoomData): Single<MapData>

    fun getLocalExtensionMap(room: RoomData): MapEntity?

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
