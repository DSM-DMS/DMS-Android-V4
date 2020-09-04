package com.dsm.dms.data.repository

import com.dsm.dms.data.datasource.StayDataSource
import com.dsm.dms.domain.entity.enums.StayInfo
import com.dsm.dms.domain.repository.StayRepository
import io.reactivex.Completable
import io.reactivex.Single


class StayRepositoryImpl(
    private val dataSource: StayDataSource
): StayRepository {

    override fun getRemoteStayInfo(): Single<StayInfo> =
        dataSource.getRemoteStayInfo()

    override fun postRemoteStayInfo(stayInfo: StayInfo): Completable =
        dataSource.postRemoteStayInfo(stayInfo)

    override fun getLocalStayInfo(): StayInfo? =
        dataSource.getLocalStayInfo()

    override fun saveLocalStayInfo(stayInfo: StayInfo) =
        dataSource.saveLocalStayInfo(stayInfo)

}
