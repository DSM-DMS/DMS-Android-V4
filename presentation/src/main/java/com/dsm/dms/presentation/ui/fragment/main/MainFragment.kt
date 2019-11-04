package com.dsm.dms.presentation.ui.fragment.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.EndPointDataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentMainBinding
import com.dsm.dms.presentation.viewmodel.main.MainViewModel
import com.dsm.dms.presentation.viewmodel.main.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class MainFragment : EndPointDataBindingFragment<FragmentMainBinding>() {

    override val layoutId: Int = R.layout.fragment_main

    @Inject
    lateinit var factory: MainViewModelFactory

    override val viewModel by lazy {
        ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        main_navigation.setupWithNavController(
            Navigation.findNavController(requireActivity(), R.id.main_container)
        )
    }

}