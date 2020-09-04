package com.dsm.dms.presentation.base

import android.content.Context

interface ResourcesProvider {
  fun getString(resId: Int): String
}

class ResourcesProviderImpl(val context: Context) : ResourcesProvider {

  override fun getString(resId: Int) = context.getString(resId)

}
