package com.dsm.dms.presentation.base

import androidx.lifecycle.Lifecycle

interface LifecycleCallback {
    fun apply(event: Lifecycle.Event)
}