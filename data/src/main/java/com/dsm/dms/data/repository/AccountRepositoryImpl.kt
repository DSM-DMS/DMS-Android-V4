package com.dsm.dms.data.repository

import com.dsm.dms.data.datasource.AccountDataSource
import com.dsm.dms.data.entity.toDataEntity
import com.dsm.dms.data.entity.toEntity
import com.dsm.dms.domain.entity.Auth
import com.dsm.dms.domain.entity.ChangePassword
import com.dsm.dms.domain.entity.Token
import com.dsm.dms.domain.repository.AccountRepository
import io.reactivex.Completable
import io.reactivex.Single

class AccountRepositoryImpl(
    private val dataSource: AccountDataSource
): AccountRepository {

    override fun signIn(auth: Auth): Single<Token> =
        dataSource.signIn(auth.toDataEntity()).map { it.toEntity() }

    override fun signUp(auth: Auth): Completable =
        dataSource.signUp(auth.toDataEntity())

    override fun changePassword(changePassword: ChangePassword): Completable =
        dataSource.changePassword(changePassword.toDataEntity())

    override fun temporaryPassword(auth: Auth): Completable =
        dataSource.temporaryPassword(auth.toDataEntity())

    override fun saveToken(token: String, isAccess: Boolean) =
        dataSource.saveToken(token, isAccess)

    override fun getToken(isAccess: Boolean): Single<String> =
        dataSource.getToken(isAccess)

}
