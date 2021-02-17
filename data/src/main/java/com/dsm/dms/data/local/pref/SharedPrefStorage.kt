package com.dsm.dms.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class SharedPrefStorage(val context: Context): LocalStorage {
    override fun saveToken(token: String, access: Boolean) =
        getPref(context).edit().let {
            it.putString(getTokenKey(access), token)
            it.apply()
        }

    override fun getToken(isAccess: Boolean): String =
        "Bearer " + getPref(context).getString(getTokenKey(isAccess), "")

    override fun removeToken() =
        getPref(context).edit().let {
            it.remove(getTokenKey(true))
            it.apply()
        }

    override fun saveSetting(title: String, data: Boolean) {
        getPref(context).edit().let {
            it.putBoolean(title, data)
            it.apply()
        }
    }

    override fun getSetting(title: String): Boolean =
        getPref(context).getBoolean(title, false)

    private fun getPref(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    private fun getTokenKey(isAccess: Boolean): String = if (isAccess) "Access" else "Refresh"
}