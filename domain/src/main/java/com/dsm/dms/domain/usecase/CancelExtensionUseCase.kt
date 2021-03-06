package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.service.ExtensionService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class CancelExtensionUseCase(
    private val service: ExtensionService,
    composite: CompositeDisposable
): UseCase<Int, Result<Unit>>(composite) {

    override fun create(time: Int): Single<Result<Unit>> =
        service.cancelExtension(time)

}
