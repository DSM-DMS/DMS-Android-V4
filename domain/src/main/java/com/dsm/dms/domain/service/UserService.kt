package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.User
import io.reactivex.Single


interface UserService {

    fun getUser(uuid: String): Single<Result<User>>

}
