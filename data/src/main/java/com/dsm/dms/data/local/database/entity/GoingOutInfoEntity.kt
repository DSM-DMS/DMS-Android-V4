package com.dsm.dms.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dsm.dms.domain.entity.GoingOutInfo
import com.dsm.dms.domain.entity.enums.GoingOutType


@Entity
data class GoingOutInfoEntity(
    @PrimaryKey
    var id: Int,
    var type: GoingOutType,
    var date: String,
    var place: String
)
