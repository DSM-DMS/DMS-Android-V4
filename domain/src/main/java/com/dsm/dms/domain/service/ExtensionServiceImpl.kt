package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.entity.Map
import com.dsm.dms.domain.repository.ExtensionRepository
import com.dsm.dms.domain.toResult
import com.dsm.dms.domain.toSingleResult
import io.reactivex.Single

class ExtensionServiceImpl(
    private val repository: ExtensionRepository,
    private val handler: ErrorHandler
): ExtensionService {

    override fun getExtensionMap(time: Int, classNum: Int): Single<Result<Map>> =
        repository.getRemoteExtensionMap(time, classNum)
            .toResult(
                handler = handler,
                localData = repository.getLocalExtensionMap(time, classNum),
                saveLocalFun = { T -> repository.saveLocalExtensionMap(T) }
            )



    override fun getExtensionInfo(time: Int): Single<Result<ExtensionInfo>> =
        repository.getRemoteExtensionInfo(time)
            .toResult(
                handler = handler,
                localData = repository.getLocalExtensionInfo(time),
                saveLocalFun = { T -> repository.saveLocalExtensionInfo(T) }
            )

    override fun postExtensionInfo(extensionInfo: ExtensionInfo): Single<Result<Unit>> =
        repository.postRemoteExtensionInfo(extensionInfo)
            .toSingleResult(
                handler = handler,
                data = extensionInfo,
                localFun = { T -> repository.saveLocalExtensionInfo(T) }
            )

    override fun deleteExtensionInfo(time: Int): Single<Result<Unit>> =
        repository.deleteRemoteExtensionInfo(time)
            .toSingleResult(
                handler = handler,
                data = time,
                localFun = { T -> repository.deleteLocalExtensionInfo(T) }
            )
}
