package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.service.ExtensionService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class GetExtensionInfoUseCase(
    private val service: ExtensionService,
    composite: CompositeDisposable
): UseCase<Int, Result<ExtensionInfo>>(composite) {

    override fun create(time: Int): Single<Result<ExtensionInfo>> =
        service.getExtensionInfo(time)

}
