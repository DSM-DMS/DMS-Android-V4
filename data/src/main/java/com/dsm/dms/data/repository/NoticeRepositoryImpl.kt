package com.dsm.dms.data.repository

import com.dsm.dms.data.datasource.NoticeDataSource
import com.dsm.dms.data.entity.toDataEntity
import com.dsm.dms.data.entity.toDbEntity
import com.dsm.dms.data.entity.toEntity
import com.dsm.dms.domain.entity.Notice
import com.dsm.dms.domain.repository.NoticeRepository
import io.reactivex.Single

class NoticeRepositoryImpl(
    private val dataSource: NoticeDataSource
): NoticeRepository {

    override fun getRemoteNotice(): Single<List<Notice>> =
        dataSource.getRemoteNotice().map { response ->
            response.notice.map { data ->
                data.toEntity()
            }
        }

    override fun getLocalNotice(): List<Notice>? =
        dataSource.getLocalNotice()?.map { it.toDataEntity().toEntity() }

    override fun saveLocalNotice(vararg notice: Notice) =
        dataSource.saveLocalNotice(
            *notice.map {
                it.toDataEntity().toDbEntity()
            }.toTypedArray()
        )

    override fun deleteLocalNotice(id: Int) =
        dataSource.deleteLocalNotice(id)

}