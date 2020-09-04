package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.ExtensionInfo
import com.dsm.dms.domain.service.ExtensionService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

class ApplyExtensionUseCase(
    private val service: ExtensionService,
    composite: CompositeDisposable
): UseCase<ExtensionInfo, Result<Unit>>(composite) {

    override fun create(extensionInfo: ExtensionInfo): Single<Result<Unit>> =
        service.applyExtension(extensionInfo)

}
