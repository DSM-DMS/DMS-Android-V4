package com.dsm.dms.data.repository

import com.dsm.dms.data.datasource.PointNoticeDataSource
import com.dsm.dms.data.entity.toDataEntity
import com.dsm.dms.data.entity.toDbEntity
import com.dsm.dms.data.entity.toEntity
import com.dsm.dms.domain.entity.Point
import com.dsm.dms.domain.repository.PointNoticeRepository
import io.reactivex.Single


class PointNoticeRepositoryImpl(
    private val dataSource: PointNoticeDataSource
): PointNoticeRepository {

    override fun getRemotePointNotice(): Single<List<Point>> =
        dataSource.getRemotePointNotice().map { response ->
            response.point.map { data ->
                data.toEntity()
            }
        }

    override fun getLocalPointNotice(): List<Point>? =
        dataSource.getLocalPointNotice()?.map { it.toDataEntity().toEntity() }

    override fun saveLocalPointNotice(vararg point: Point) =
        dataSource.saveLocalPointNotice(
            *point.map {
                it.toDataEntity().toDbEntity()
            }.toTypedArray()
        )

    override fun deleteLocalPointNotice(name: String) =
        dataSource.deleteLocalPointNotice(name)

}
