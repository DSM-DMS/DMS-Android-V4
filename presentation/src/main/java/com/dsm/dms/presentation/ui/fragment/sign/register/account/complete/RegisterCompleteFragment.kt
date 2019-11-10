package com.dsm.dms.presentation.ui.fragment.sign.register.account.complete

import android.os.Bundle
import android.view.View
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentRegisterCompleteBinding
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import javax.inject.Inject

class RegisterCompleteFragment : DataBindingFragment<FragmentRegisterCompleteBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_register_complete

    @Inject
    override lateinit var viewModel: RegisterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
    }
}