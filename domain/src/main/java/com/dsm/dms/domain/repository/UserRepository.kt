package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.User
import io.reactivex.Single


interface UserRepository {

    fun getRemoteUserData(uuid: String): Single<User>

    fun getLocalUserData(): User?

    fun saveLocalUserData(vararg user: User)

    fun deleteLocalUserData()

}
