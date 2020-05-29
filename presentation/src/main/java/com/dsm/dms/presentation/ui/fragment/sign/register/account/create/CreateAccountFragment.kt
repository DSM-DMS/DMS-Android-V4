package com.dsm.dms.presentation.ui.fragment.sign.register.account.create

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentCreateAccountBinding
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import javax.inject.Inject

class CreateAccountFragment : DataBindingFragment<FragmentCreateAccountBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_create_account

    @Inject
    override lateinit var viewModel: RegisterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
    }

    override fun observeEvent() {

    }
}