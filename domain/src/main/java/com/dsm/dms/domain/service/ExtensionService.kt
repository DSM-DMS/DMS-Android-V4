package com.dsm.dms.domain.service

import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.entity.Map
import io.reactivex.Single
import com.dsm.dms.domain.base.Result


interface ExtensionService {

    fun getExtensionMap(time: Int, classNum: Int): Single<Result<Map>>

    fun getExtensionInfo(time: Int): Single<Result<ExtensionInfo>>

    fun applyExtension(extensionInfo: ExtensionInfo): Single<Result<Unit>>

    fun cancelExtension(time: Int): Single<Result<Unit>>

}
