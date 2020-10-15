package com.dsm.dms.domain.service

import com.dsm.dms.domain.`object`.Room
import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.entity.Map
import io.reactivex.Single
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.enums.ClassNum


interface ExtensionService {

    fun getExtensionMap(room: Room): Single<Result<Map>>

    fun getExtensionInfo(time: Int): Single<Result<ExtensionInfo>>

    fun applyExtension(extensionInfo: ExtensionInfo): Single<Result<Unit>>

    fun cancelExtension(time: Int): Single<Result<Unit>>

}
