package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.enums.StayInfo
import io.reactivex.Single


interface StayService {

    fun getStayInfo(): Single<Result<StayInfo>>

    fun postStayInfo(stayInfo: StayInfo): Single<Result<Unit>>

}
