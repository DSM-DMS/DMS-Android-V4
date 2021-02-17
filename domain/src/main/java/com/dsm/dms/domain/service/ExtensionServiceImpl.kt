package com.dsm.dms.domain.service

import com.dsm.dms.domain.`object`.Room
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.entity.Map
import com.dsm.dms.domain.entity.enums.ClassNum
import com.dsm.dms.domain.repository.ExtensionRepository
import com.dsm.dms.domain.toResult
import com.dsm.dms.domain.toSingleResult
import io.reactivex.Single

class ExtensionServiceImpl(
    private val repository: ExtensionRepository,
    private val handler: ErrorHandler
): ExtensionService {

    override fun getExtensionMap(room: Room): Single<Result<Map>> =
        repository.getRemoteExtensionMap(room)
            .toResult(
                handler = handler,
                getLocalDataFun = { repository.getLocalExtensionMap(room) },
                saveLocalFun = { T -> repository.saveLocalExtensionMap(T) }
            )

    override fun getExtensionInfo(time: Int): Single<Result<ExtensionInfo>> =
        repository.getRemoteExtensionInfo(time)
            .toResult(
                handler = handler,
                getLocalDataFun= { repository.getLocalExtensionInfo(time) },
                saveLocalFun = { T -> repository.saveLocalExtensionInfo(T) }
            )

    override fun applyExtension(extensionInfo: ExtensionInfo): Single<Result<Unit>> =
        repository.postRemoteExtensionInfo(extensionInfo)
            .toSingleResult(
                handler = handler,
                data = extensionInfo,
                localFun = { T -> repository.saveLocalExtensionInfo(T) }
            )

    override fun cancelExtension(time: Int): Single<Result<Unit>> =
        repository.deleteRemoteExtensionInfo(time)
            .toSingleResult(
                handler = handler,
                data = time,
                localFun = { T -> repository.deleteLocalExtensionInfo(T) }
            )
}
