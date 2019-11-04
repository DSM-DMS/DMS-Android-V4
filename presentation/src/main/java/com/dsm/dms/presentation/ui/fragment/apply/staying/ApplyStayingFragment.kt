package com.dsm.dms.presentation.ui.fragment.apply.staying

import androidx.lifecycle.ViewModelProviders
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentApplyStayingBinding
import com.dsm.dms.presentation.viewmodel.main.apply.staying.ApplyStayingViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.staying.ApplyStayingViewModelFactory
import javax.inject.Inject

class ApplyStayingFragment: DataBindingFragment<FragmentApplyStayingBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_staying

    @Inject
    lateinit var factory: ApplyStayingViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(ApplyStayingViewModel::class.java) }
}