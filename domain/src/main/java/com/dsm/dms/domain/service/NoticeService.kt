package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Notice
import com.dsm.dms.domain.entity.Point
import io.reactivex.Single


interface NoticeService {

    fun getNotice(): Single<Result<List<Notice>>>

    fun getPointNotice(): Single<Result<List<Point>>>

}
