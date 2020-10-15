package com.dsm.dms.domain.usecase

import com.dsm.dms.domain.`object`.Room
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.base.UseCase
import com.dsm.dms.domain.entity.Map
import com.dsm.dms.domain.service.ExtensionService
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable


class GetExtensionMapUseCase(
    private val service: ExtensionService,
    composite: CompositeDisposable
): UseCase<Room, Result<Map>>(composite) {

    override fun create(room: Room): Single<Result<Map>> =
        service.getExtensionMap(room)

}
