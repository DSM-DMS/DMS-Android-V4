package com.dsm.dms.presentation.model

import android.view.View
import com.dsm.dms.presentation.R


data class VisibilityModel(
    var visibleContent: Int = View.GONE,
    var visibleLoad: Int = View.VISIBLE,
    var visibleError: Int = View.GONE,
    var errorResource: Int = R.drawable.ic_network_error
)
