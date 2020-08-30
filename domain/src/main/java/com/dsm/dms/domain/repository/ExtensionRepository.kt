package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.entity.Map
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface ExtensionRepository {

    fun getRemoteExtensionMap(time: Int, classNum: Int): Single<Map>

    fun getLocalExtensionMap(time: Int, classNum: Int): Map?

    fun saveLocalExtensionMap(vararg map: Map)

    fun deleteLocalExtensionMap(time: Int, classNum: Int)

    fun getRemoteExtensionInfo(time: Int): Single<ExtensionInfo>

    fun getLocalExtensionInfo(time: Int): ExtensionInfo?

    fun postRemoteExtensionInfo(extensionInfo: ExtensionInfo): Completable

    fun deleteRemoteExtensionInfo(time: Int): Completable

    fun saveLocalExtensionInfo(vararg extensionInfo: ExtensionInfo)

    fun deleteLocalExtensionInfo(time: Int)

    fun getLocalAllExtensionInfo(): List<ExtensionInfo>?

}