package com.dsm.dms.data.local.database.converter


abstract class Converter<T1, T2> {
    abstract fun from(value: T1): T2
    abstract fun to(value: T2): T1
}
