package com.dsm.dms.data.local.database.converter

import androidx.room.TypeConverter
import com.dsm.dms.domain.entity.enums.StayInfo


class StayInfoConverter: Converter<StayInfo, Int>() {

    @TypeConverter
    override fun from(value: StayInfo): Int =
        value.ordinal + 1

    @TypeConverter
    override fun to(value: Int): StayInfo =
        when(value) {
            1 -> StayInfo.FRIDAY_GO
            2 -> StayInfo.SATURDAY_GO
            3 -> StayInfo.SATURDAY_BACK
            4 -> StayInfo.STAY
            else -> StayInfo.STAY
        }

}
