package com.dsm.dms.data.local.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson


class StringListConverter: Converter<List<String>, String>() {

    @TypeConverter
    override fun from(value: List<String>): String =
        Gson().toJson(value)

    @TypeConverter
    override fun to(value: String): List<String> =
        Gson().fromJson(value, Array<String>::class.java).toList()

}
