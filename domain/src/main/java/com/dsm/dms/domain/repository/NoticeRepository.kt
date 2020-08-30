package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.Notice
import com.dsm.dms.domain.entity.Point
import io.reactivex.Single


interface NoticeRepository {

    fun getRemoteNotice(): Single<List<Notice>>

    fun getLocalNotice(): List<Notice>?

    fun saveLocalNotice(vararg notice: Notice)

    fun deleteLocalNotice(id: Int)

    fun getRemotePointNotice(): Single<List<Point>>

    fun getLocalPointNotice(): List<Point>?

    fun saveLocalPointNotice(vararg point: Point)

    fun deleteLocalPointNotice(name: String)

}
