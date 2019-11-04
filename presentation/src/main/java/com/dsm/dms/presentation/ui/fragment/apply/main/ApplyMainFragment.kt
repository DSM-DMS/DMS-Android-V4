package com.dsm.dms.presentation.ui.fragment.apply.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentApplyMainBinding
import com.dsm.dms.presentation.viewmodel.main.apply.main.ApplyMainViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.main.ApplyMainViewModelFactory
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

    }
}