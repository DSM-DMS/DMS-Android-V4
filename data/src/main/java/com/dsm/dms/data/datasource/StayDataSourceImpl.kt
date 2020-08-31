package com.dsm.dms.data.datasource

import com.dsm.dms.data.local.database.dao.UserDao
import com.dsm.dms.data.remote.ApplyApi
import com.dsm.dms.domain.entity.enums.StayInfo
import io.reactivex.Completable
import io.reactivex.Single


class StayDataSourceImpl(
    private val applyApi: ApplyApi,
    private val userDao: UserDao
): StayDataSource {

    override fun getRemoteStayInfo(): Single<StayInfo> =
        applyApi.getStay()

    override fun getLocalStayInfo(): StayInfo? =
        userDao.getUserData()?.stayInfo

    override fun postRemoteStayInfo(stayInfo: StayInfo): Completable =
        applyApi.postStay(stayInfo)

    override fun saveLocalStayInfo(stayInfo: StayInfo) {
        userDao.getUserData()?.let {
            userDao.saveUserData(
                it.apply {
                    this.stayInfo = stayInfo
                }
            )
        }
    }

}
