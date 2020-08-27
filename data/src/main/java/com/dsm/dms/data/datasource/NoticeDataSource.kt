package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.response.GetListNoticeResponse
import com.dsm.dms.data.local.database.entity.NoticeEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


interface NoticeDataSource {

    fun getRemoteNotice(): Single<GetListNoticeResponse>

    fun getLocalNotice(): List<NoticeEntity>?

    fun saveLocalNotice(vararg noticeEntity: NoticeEntity)

    fun deleteLocalNotice(id: Int)

}
