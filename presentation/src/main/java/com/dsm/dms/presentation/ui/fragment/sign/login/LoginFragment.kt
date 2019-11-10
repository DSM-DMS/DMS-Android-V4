package com.dsm.dms.presentation.ui.fragment.sign.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentLoginBinding
import com.dsm.dms.presentation.viewmodel.sign.login.LoginViewModel
import com.dsm.dms.presentation.viewmodel.sign.login.LoginViewModelFactory
import javax.inject.Inject

class LoginFragment : DataBindingFragment<FragmentLoginBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_login

    @Inject
    lateinit var factory: LoginViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(LoginViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginSingleLiveEvent
            .observe(this, Observer {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            })

        viewModel.registerSingleLiveEvent
            .observe(this, Observer {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            })

        binding.vm = viewModel
    }
}