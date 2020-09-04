package com.dsm.dms.data.repository

import com.dsm.dms.data.datasource.ExtensionDataSource
import com.dsm.dms.data.entity.toDataEntity
import com.dsm.dms.data.entity.toDbEntity
import com.dsm.dms.data.entity.toEntity
import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.entity.Map
import com.dsm.dms.domain.repository.ExtensionRepository
import io.reactivex.Completable
import io.reactivex.Single


class ExtensionRepositoryImpl(
    private val dataSource: ExtensionDataSource
): ExtensionRepository {

    override fun getRemoteExtensionMap(time: Int, classNum: Int): Single<Map> =
        dataSource.getRemoteExtensionMap(time, classNum).map { it.toEntity() }

    override fun getLocalExtensionMap(time: Int, classNum: Int): Map? =
        dataSource.getLocalExtensionMap(time, classNum)?.toDataEntity()?.toEntity()

    override fun saveLocalExtensionMap(vararg map: Map) =
        dataSource.saveLocalExtensionMap(
            *map.map {
                it.toDataEntity().toDbEntity()
            }.toTypedArray()
        )

    override fun deleteLocalExtensionMap(time: Int, classNum: Int) =
        dataSource.deleteLocalExtensionMap(time, classNum)

    override fun getRemoteExtensionInfo(time: Int): Single<ExtensionInfo> =
        dataSource.getRemoteExtensionInfo(time).map { it.toEntity() }

    override fun getLocalExtensionInfo(time: Int) =
        dataSource.getLocalExtensionInfo(time)?.toDataEntity()?.toEntity()

    override fun postRemoteExtensionInfo(extensionInfo: ExtensionInfo): Completable =
        dataSource.postRemoteExtensionInfo(extensionInfo.toDataEntity())

    override fun deleteRemoteExtensionInfo(time: Int): Completable =
        dataSource.deleteRemoteExtensionInfo(time)

    override fun saveLocalExtensionInfo(vararg extensionInfo: ExtensionInfo) =
        dataSource.saveLocalExtensionInfo(
            *extensionInfo.map {
                it.toDataEntity().toDbEntity()
            }.toTypedArray()
        )

    override fun deleteLocalExtensionInfo(time: Int) =
        dataSource.deleteLocalExtensionInfo(time)

    override fun getLocalAllExtensionInfo(): List<ExtensionInfo>? =
        dataSource.getLocalAllExtensionInfo()?.map { it.toDataEntity().toEntity() }

}
