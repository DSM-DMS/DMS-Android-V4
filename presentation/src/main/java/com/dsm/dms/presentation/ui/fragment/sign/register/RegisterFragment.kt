package com.dsm.dms.presentation.ui.fragment.sign.register

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentRegisterBinding
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_register.*
import javax.inject.Inject

class RegisterFragment : DataBindingInjectFragment<FragmentRegisterBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_register

    @Inject
    override lateinit var viewModel: RegisterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        viewModel.nowStateLabelData.value = "CertifyAccount"
    }

    override fun observeEvent() {

        viewModel.backEvent.observe(this, Observer {
            back()
        })

        viewModel.nextEvent.observe(this, Observer {
            Navigation.findNavController(requireActivity(), R.id.register_container).let {
                when (it.currentDestination?.label) {
                    "CertifyAccountFragment" -> {
                        it.navigate(R.id.action_certifyAccountFragment_to_createAccountFragment)
                        viewModel.nowStateLabelData.value = "CreateAccount"
                    }
                    "CreateAccountFragment" -> {
                        it.navigate(R.id.action_createAccountFragment_to_registerCompleteFragment)

                        register_back_img.visibility = View.GONE
                        register_next_btn.visibility = View.GONE
                        register_complete_btn.visibility = View.VISIBLE

                        viewModel.nowStateLabelData.value = "Complete"
                    }
                }
            }
        })

        viewModel.completeEvent.observe(this, Observer {
            findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
        })

        viewModel.showMessageEvent.observe(this, Observer {
            Snackbar.make(this.rootView, it, Snackbar.LENGTH_SHORT).show()
        })

    }

}