package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.response.GetListNoticeResponse
import com.dsm.dms.data.dto.response.GetListPointNoticeResponse
import com.dsm.dms.data.local.database.entity.NoticeEntity
import com.dsm.dms.data.local.database.entity.PointEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single


interface NoticeDataSource {

    fun getRemoteNotice(): Single<GetListNoticeResponse>

    fun getLocalNotice(): List<NoticeEntity>?

    fun saveLocalNotice(vararg noticeEntity: NoticeEntity)

    fun deleteLocalNotice(id: Int)

    fun getRemotePointNotice(): Single<GetListPointNoticeResponse>

    fun getLocalPointNotice(): List<PointEntity>?

    fun saveLocalPointNotice(vararg pointEntity: PointEntity)

    fun deleteLocalPointNotice(name: String)

}
