package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.User
import com.dsm.dms.domain.repository.ExtensionRepository
import com.dsm.dms.domain.repository.GoingOutRepository
import com.dsm.dms.domain.repository.UserRepository
import com.dsm.dms.domain.toResult
import io.reactivex.Single

class UserServiceImpl(
    private val userRepository: UserRepository,
    private val goingOutRepository: GoingOutRepository,
    private val extensionRepository: ExtensionRepository,
    private val handler: ErrorHandler
): UserService {

    override fun getUser(uuid: String): Single<Result<User>> =
        userRepository.getRemoteUserData(uuid)
            .map {
                it.apply {
                    apply.extension = extensionRepository.getLocalAllExtensionInfo()
                    apply.goingOut = goingOutRepository.getLocalGoingOutInfo()
                }
            }.toResult(
                handler = handler,
                getLocalDataFun = { userRepository.getLocalUserData() },
                saveLocalFun = { T -> userRepository.saveLocalUserData(T) }
            )

}
