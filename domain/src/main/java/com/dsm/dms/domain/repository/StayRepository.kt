package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.enums.StayInfo
import io.reactivex.Completable
import io.reactivex.Single


interface StayRepository {

    fun getRemoteStayInfo(): Single<StayInfo>

    fun postRemoteStayInfo(stayInfo: StayInfo): Completable

    fun getLocalStayInfo(): StayInfo?

    fun saveLocalStayInfo(stayInfo: StayInfo)

}
