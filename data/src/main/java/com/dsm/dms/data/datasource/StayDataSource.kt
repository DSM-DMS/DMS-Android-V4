package com.dsm.dms.data.datasource

import com.dsm.dms.domain.entity.enums.StayInfo
import io.reactivex.Completable
import io.reactivex.Single


interface StayDataSource {

    fun getRemoteStayInfo(): Single<StayInfo>

    fun postRemoteStayInfo(stayInfo: StayInfo): Completable

    fun getLocalStayInfo(): StayInfo?

    fun saveLocalStayInfo(stayInfo: StayInfo)

}
