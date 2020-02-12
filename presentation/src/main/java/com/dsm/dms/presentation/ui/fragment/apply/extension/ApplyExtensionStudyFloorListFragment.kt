package com.dsm.dms.presentation.ui.fragment.apply.extension

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentApplyExtensionStudyFloorListBinding
import com.dsm.dms.presentation.viewmodel.main.apply.extension.ApplyExtensionFloorListViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.extension.ApplyExtensionFloorListViewModelFactory
import javax.inject.Inject

class ApplyExtensionStudyFloorListFragment: DataBindingFragment<FragmentApplyExtensionStudyFloorListBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_extension_study_floor_list

    @Inject
    lateinit var factory: ApplyExtensionFloorListViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(ApplyExtensionFloorListViewModel::class.java) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(
            this, object: OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    backToMain()
                }
            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.backToMainEvent.observe(this, Observer {
            backToMain()
        })
    }

    private fun backToMain()
            = findNavController().navigate(R.id.action_applyExtensionStudyFloorListFragment_to_applyMainFragment)
}