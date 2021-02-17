package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.response.GetListPointNoticeResponse
import com.dsm.dms.data.local.database.dao.PointNoticeDao
import com.dsm.dms.data.local.database.entity.PointEntity
import com.dsm.dms.data.remote.BaseApi
import io.reactivex.Single


class PointNoticeDataSourceImpl(
    private val api: BaseApi,
    private val pointNoticeDao: PointNoticeDao
): PointNoticeDataSource {

    override fun getRemotePointNotice(): Single<GetListPointNoticeResponse> =
        api.getPointNotice()

    override fun getLocalPointNotice(): List<PointEntity>? =
        pointNoticeDao.getAllPointNoticeData()

    override fun saveLocalPointNotice(vararg pointEntity: PointEntity) =
        pointNoticeDao.savePointNoticeData(*pointEntity)

    override fun deleteLocalPointNotice(name: String) =
        pointNoticeDao.deletePointNoticeData(name)

}
