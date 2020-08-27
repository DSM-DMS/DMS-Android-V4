package com.dsm.dms.data.datasource

import com.dsm.dms.data.entity.UserData
import com.dsm.dms.data.local.database.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

interface UserDataSource {

    fun getRemoteUserData(uuid: String): Single<UserData>

    fun getLocalUserData(): UserEntity?

    fun saveLocalUserData(vararg userEntity: UserEntity)

    fun deleteLocalUserData()

}
