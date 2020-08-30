package com.dsm.dms.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController

abstract class DataBindingFragment<T : ViewDataBinding> : Fragment() {

    lateinit var rootView: View
    lateinit var binding: T

    abstract val layoutId: Int

    abstract val viewModel: BaseViewModel

    private val lifecycleOwner = LifecycleOwner()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        rootView = binding.root
        binding.lifecycleOwner = this
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        register(viewModel)
        observeEvent()
    }

    abstract fun observeEvent()

    open fun back() {
        findNavController().navigateUp()
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

    fun register(callback : LifecycleCallback) {
        lifecycleOwner.register(callback)
    }

    fun unregister(callback : LifecycleCallback) {
        lifecycleOwner.unregister(callback)
    }

    private fun notifyEvent(event : Lifecycle.Event) {
        lifecycleOwner.notifyEvent(event)
    }
}