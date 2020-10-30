package com.dsm.dms.data.local.pref

interface LocalStorage {
    fun saveToken(token: String, access: Boolean)
    fun getToken(isAccess: Boolean): String
    fun removeToken()

    fun saveSetting(title: String, data: Boolean)
    fun getSetting(title: String): Boolean

}