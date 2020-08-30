package com.dsm.dms.presentation.ui.fragment.apply.extension

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.transition.TransitionInflater
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentApplyExtensionFloorListBinding
import com.dsm.dms.presentation.viewmodel.main.apply.extension.ApplyExtensionFloorListViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.extension.ApplyExtensionFloorListViewModelFactory
import kotlinx.android.synthetic.main.fragment_apply_extension_floor_list.*
import javax.inject.Inject

class ApplyExtensionFloorListFragment: DataBindingInjectFragment<FragmentApplyExtensionFloorListBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_extension_floor_list

    @Inject
    lateinit var factory: ApplyExtensionFloorListViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyExtensionFloorListViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.backToMainEvent.observe(this, Observer {
            back()
        })
        viewModel.goToDetailEvent.observe(this, Observer {
            goToDetail(it)
        })
    }

    private fun goToDetail(floor: Int) {
        Navigation.findNavController(requireActivity(), R.id.fragment_container).navigate(
            R.id.action_mainFragment_to_applyExtensionFloorDetailFragment,
            Bundle().apply {
                this.putInt("floor", floor)
            }
        )
    }
}
