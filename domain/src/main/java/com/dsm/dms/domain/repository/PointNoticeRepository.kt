package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.Point
import io.reactivex.Single


interface PointNoticeRepository {

    fun getRemotePointNotice(): Single<List<Point>>

    fun getLocalPointNotice(): List<Point>?

    fun saveLocalPointNotice(vararg point: Point)

    fun deleteLocalPointNotice(name: String)

}
