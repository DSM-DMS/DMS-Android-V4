package com.dsm.dms.domain.service

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Notice
import io.reactivex.Single


interface NoticeService {

    fun getNotice(): Single<Result<List<Notice>>>

}
