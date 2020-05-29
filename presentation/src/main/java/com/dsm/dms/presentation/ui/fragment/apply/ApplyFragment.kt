package com.dsm.dms.presentation.ui.fragment.apply

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentApplyBinding
import com.dsm.dms.presentation.viewmodel.main.apply.ApplyViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.ApplyViewModelFactory
import javax.inject.Inject

class ApplyFragment: DataBindingFragment<FragmentApplyBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply

    @Inject
    lateinit var factory: ApplyViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {

    }
}