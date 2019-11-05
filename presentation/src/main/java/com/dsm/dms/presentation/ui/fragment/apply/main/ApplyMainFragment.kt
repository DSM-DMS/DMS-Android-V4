package com.dsm.dms.presentation.ui.fragment.apply.main

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentApplyMainBinding
import com.dsm.dms.presentation.viewmodel.main.apply.main.ApplyMainViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.main.ApplyMainViewModelFactory
import kotlinx.android.synthetic.main.fragment_apply_main.view.*
import javax.inject.Inject

class ApplyMainFragment: DataBindingFragment<FragmentApplyMainBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_main

    @Inject
    lateinit var factory: ApplyMainViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(ApplyMainViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        observeEvent()
    }

    private fun observeEvent() {
        viewModel.goStayingEvent.observe(this, Observer {
            findNavController().navigate(R.id.action_applyMainFragment_to_applyStayingFragment)
        })
        viewModel.goStudyingEvent.observe(this, Observer {

        })
        viewModel.goGoingOutEvent.observe(this, Observer {

        })
        viewModel.goMusicEvent.observe(this, Observer{

        })
        viewModel.goRestEvent.observe(this, Observer {

        })
    }
}