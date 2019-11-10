package com.dsm.dms.presentation.ui.fragment.sign.register.account.certify

import android.os.Bundle
import android.view.View
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentCertifyAccountBinding
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import javax.inject.Inject

class CertifyAccountFragment : DataBindingFragment<FragmentCertifyAccountBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_certify_account

    @Inject
    override lateinit var viewModel: RegisterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
    }

}