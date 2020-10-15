package com.dsm.dms.data.local.database.converter

import androidx.room.TypeConverter
import com.dsm.dms.domain.entity.enums.ClassNum


class ClassNumConverter: Converter<ClassNum, Int>() {

    @TypeConverter
    override fun from(value: ClassNum): Int =
        value.ordinal + 1

    @TypeConverter
    override fun to(value: Int): ClassNum =
        when(value) {
            1 -> ClassNum.GAONSIL
            2 -> ClassNum.NAONSIL
            3 -> ClassNum.DAONSIL
            4 -> ClassNum.LAONSIL
            5 -> ClassNum.SECOND_FLOOR_ROOM
            6 -> ClassNum.THIRD_FLOOR_SCHOOL_SIDE_ROOM
            7 -> ClassNum.THIRD_FLOOR_DORMITORY_SIDE_ROOM
            8 -> ClassNum.FOURTH_FLOOR_SCHOOL_SIDE_ROOM
            9 -> ClassNum.FOURTH_FLOOR_DORMITORY_SIDE_ROOM
            10 -> ClassNum.FIFTH_FLOOR_ROOM
            11 -> ClassNum.THIRD_FLOOR_SOFA
            else -> ClassNum.GAONSIL
        }
}
