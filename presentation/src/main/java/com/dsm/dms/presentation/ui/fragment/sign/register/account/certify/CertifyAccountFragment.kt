package com.dsm.dms.presentation.ui.fragment.sign.register.account.certify

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentCertifyAccountBinding
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_certify_account.*
import javax.inject.Inject

class CertifyAccountFragment : DataBindingInjectFragment<FragmentCertifyAccountBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_certify_account

    @Inject
    override lateinit var viewModel: RegisterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            back()
        }
    }

    override fun back() {
        Navigation.findNavController(requireActivity(), R.id.fragment_container).navigateUp()
    }

    override fun observeEvent() {
        viewModel.onVerifyLoadingEvent.observe(this, Observer {
            certify_account_check_btn.onLoad(it)
        })
        viewModel.onVerifyErrorEvent.observe(this, Observer {
            certify_account_check_btn.onError(it)
        })
        viewModel.onVerifySuccessEvent.observe(this, Observer {
            certify_account_check_btn.isComeback = false
            certify_account_check_btn.onSuccess(it)
        })
    }
}