package com.dsm.dms.domain.repository

import com.dsm.dms.domain.entity.Notice
import io.reactivex.Single


interface NoticeRepository {

    fun getRemoteNotice(): Single<List<Notice>>

    fun getLocalNotice(): List<Notice>?

    fun saveLocalNotice(vararg notice: Notice)

    fun deleteLocalNotice(id: Int)

}
