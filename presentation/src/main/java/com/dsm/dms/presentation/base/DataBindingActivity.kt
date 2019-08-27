package com.dsm.dms.presentation.base


import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import dagger.android.support.DaggerAppCompatActivity


abstract class DataBindingActivity<T : ViewDataBinding> : DaggerAppCompatActivity() {

    lateinit var binding: T

    abstract val layoutId: Int

    private val lifecycleOwner = LifecycleOwner()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
    }

    override fun onStart() {
        super.onStart()
        notifyEvent(Lifecycle.Event.ON_START)
    }

    override fun onResume() {
        super.onResume()
        notifyEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onPause() {
        notifyEvent(Lifecycle.Event.ON_PAUSE)
        super.onPause()
    }

    override fun onStop() {
        notifyEvent(Lifecycle.Event.ON_STOP)
        super.onStop()
    }

    override fun onDestroy() {
        notifyEvent(Lifecycle.Event.ON_DESTROY)
        super.onDestroy()
    }

    fun register(callback: LifecycleCallback) {
        lifecycleOwner.register(callback)
    }

    fun unregister(callback: LifecycleCallback) {
        lifecycleOwner.unregister(callback)
    }

    private fun notifyEvent(event: Lifecycle.Event) {
        lifecycleOwner.notifyEvent(event)
    }

}
