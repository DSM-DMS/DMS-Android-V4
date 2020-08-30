package com.dsm.dms.data.datasource

import com.dsm.dms.data.dto.response.GetListPointNoticeResponse
import com.dsm.dms.data.local.database.entity.PointEntity
import io.reactivex.Single


interface PointNoticeDataSource {

    fun getRemotePointNotice(): Single<GetListPointNoticeResponse>

    fun getLocalPointNotice(): List<PointEntity>?

    fun saveLocalPointNotice(vararg pointEntity: PointEntity)

    fun deleteLocalPointNotice(name: String)

}
