package com.dsm.dms.data.local.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dsm.dms.data.entity.ApplyInfoData
import com.dsm.dms.data.entity.PointInfoData
import com.dsm.dms.domain.entity.enums.StayInfo


@Entity
data class UserEntity(
    @PrimaryKey
    var studentNumber: Int,
    var name: String,
    @Embedded
    var point: PointInfoData,
    var stayInfo: StayInfo?
)
