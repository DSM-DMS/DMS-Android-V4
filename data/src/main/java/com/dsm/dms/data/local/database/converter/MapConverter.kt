package com.dsm.dms.data.local.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson


class MapConverter: Converter<List<List<Any>>, String>() {
    @TypeConverter
    override fun from(value: List<List<Any>>): String =
        Gson().toJson(value)

    @TypeConverter
    override fun to(value: String): List<List<Any>> =
        Gson().fromJson(value, Array<Array<Any>>::class.java).map { it.toList() }
}
