package com.dsm.dms.presentation.base

import androidx.lifecycle.Lifecycle

class LifecycleOwner{

    private val callbacks = ArrayList<LifecycleCallback>()
    private var lastEvent : Lifecycle.Event = Lifecycle.Event.ON_CREATE
    fun register(callback : LifecycleCallback) {
        callback.apply(lastEvent)
        callbacks.add(callback)
    }

    fun unregister(callback : LifecycleCallback) {
        callbacks.remove(callback)
    }

    fun notifyEvent(event : Lifecycle.Event) {
        callbacks.forEach { it.apply(event) }
    }
}