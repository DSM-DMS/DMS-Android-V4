package com.dsm.dms.data.local.database.converter

import androidx.room.TypeConverter
import com.dsm.dms.domain.entity.enums.GoingOutType


class GoingOutTypeConverter: Converter<GoingOutType, Int>() {

    @TypeConverter
    override fun from(value: GoingOutType): Int =
        value.ordinal + 1

    @TypeConverter
    override fun to(value: Int): GoingOutType =
        when(value) {
            1 -> GoingOutType.COMMON_GOING
            2 -> GoingOutType.RELIGION_GOING
            3 -> GoingOutType.MEAL_GOING
            else -> GoingOutType.COMMON_GOING
        }

}
