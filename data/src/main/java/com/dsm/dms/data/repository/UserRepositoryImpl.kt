package com.dsm.dms.data.repository

import com.dsm.dms.data.datasource.UserDataSource
import com.dsm.dms.data.entity.UserData
import com.dsm.dms.data.entity.toDataEntity
import com.dsm.dms.data.entity.toDbEntity
import com.dsm.dms.data.entity.toEntity
import com.dsm.dms.data.local.database.entity.UserEntity
import com.dsm.dms.domain.entity.User
import com.dsm.dms.domain.repository.UserRepository
import io.reactivex.Single


class UserRepositoryImpl(
    private val dataSource: UserDataSource
): UserRepository {

    override fun getRemoteUserData(uuid: String): Single<User> =
        dataSource.getRemoteUserData(uuid).map { it.toEntity() }

    override fun getLocalUserData(): User? =
        dataSource.getLocalUserData()?.toDataEntity()?.toEntity()

    override fun saveLocalUserData(vararg user: User) =
        dataSource.saveLocalUserData(
            *user.map {
                it.toDataEntity().toDbEntity()
            }.toTypedArray()
        )

    override fun deleteLocalUserData() =
        dataSource.deleteLocalUserData()

}
