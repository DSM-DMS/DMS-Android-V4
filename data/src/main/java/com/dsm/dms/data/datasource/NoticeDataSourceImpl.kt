package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.response.GetListNoticeResponse
import com.dsm.dms.data.local.database.dao.NoticeDao
import com.dsm.dms.data.local.database.entity.NoticeEntity
import com.dsm.dms.data.remote.NoticeApi
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


class NoticeDataSourceImpl(
    private val api: NoticeApi,
    private val noticeDao: NoticeDao
): NoticeDataSource {
    override fun getRemoteNotice(): Single<GetListNoticeResponse> =
        api.getNotice()

    override fun getLocalNotice(): List<NoticeEntity>? =
        noticeDao.getAllNoticeData()

    override fun saveLocalNotice(vararg noticeEntity: NoticeEntity) =
        noticeDao.saveNoticeData(*noticeEntity)

    override fun deleteLocalNotice(id: Int) =
        noticeDao.deleteNoticeData(id)
}
