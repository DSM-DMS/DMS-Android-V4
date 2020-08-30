package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Point
import io.reactivex.Single


interface PointNoticeService {

    fun getPointNotice(): Single<Result<List<Point>>>

}
