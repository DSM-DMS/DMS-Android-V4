package com.dsm.dms.data.repository

import com.dsm.dms.data.datasource.GoingOutDataSource
import com.dsm.dms.data.entity.toDataEntity
import com.dsm.dms.data.entity.toDbEntity
import com.dsm.dms.data.entity.toEntity
import com.dsm.dms.domain.entity.GoingOutInfo
import com.dsm.dms.domain.repository.GoingOutRepository
import io.reactivex.Completable
import io.reactivex.Single


class GoingOutRepositoryImpl(
    private val dataSource: GoingOutDataSource
): GoingOutRepository {

    override fun getRemoteGoingOutInfo(): Single<List<GoingOutInfo>> =
        dataSource.getRemoteGoingOutInfo().map { response ->
            response.goingOut.map { data ->
                data.toEntity()
            }
        }

    override fun getLocalGoingOutInfo(): List<GoingOutInfo>? =
        dataSource.getLocalGoingOutInfo()?.map { it.toDataEntity().toEntity() }

    override fun postRemoteGoingOutInfo(goingOutInfo: GoingOutInfo): Completable =
        dataSource.postRemoteGoingOutInfo(goingOutInfo.toDataEntity())

    override fun saveLocalGoingOutInfo(vararg goingOutInfo: GoingOutInfo) =
        dataSource.saveLocalGoingOutInfo(
            *goingOutInfo.map {
                it.toDataEntity().toDbEntity()
            }.toTypedArray()
        )

    override fun patchGoingOutInfo(goingOutInfo: GoingOutInfo): Completable =
        dataSource.patchGoingOutInfo(goingOutInfo.toDataEntity())

    override fun deleteRemoteGoingOutInfo(id: Int): Completable =
        dataSource.deleteRemoteGoingOutInfo(id)

    override fun deleteLocalGoingOutInfo(id: Int) =
        dataSource.deleteLocalGoingOutInfo(id)

}
