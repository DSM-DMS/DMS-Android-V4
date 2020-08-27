package com.dsm.dms.data.datasource

import com.dsm.dms.data.entity.UserData
import com.dsm.dms.data.local.database.dao.UserDao
import com.dsm.dms.data.local.database.entity.UserEntity
import com.dsm.dms.data.remote.InfoApi
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

class UserDataSourceImpl(
    private val api: InfoApi,
    private val userDao: UserDao
): UserDataSource {

    override fun getRemoteUserData(uuid: String): Single<UserData> =
        api.getMyData(uuid)

    override fun getLocalUserData(): UserEntity? =
        userDao.getUserData()

    override fun saveLocalUserData(vararg userEntity: UserEntity) =
        userDao.saveUserData(*userEntity)

    override fun deleteLocalUserData() =
        userDao.deleteUserData()

}
