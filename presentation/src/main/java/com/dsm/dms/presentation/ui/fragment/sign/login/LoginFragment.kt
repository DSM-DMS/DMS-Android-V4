package com.dsm.dms.presentation.ui.fragment.sign.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentLoginBinding
import com.dsm.dms.presentation.viewmodel.sign.login.LoginViewModel
import com.dsm.dms.presentation.viewmodel.sign.login.LoginViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class LoginFragment : DataBindingFragment<FragmentLoginBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_login

    @Inject
    lateinit var factory: LoginViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(LoginViewModel::class.java) }

    private val disposable = CompositeDisposable()

    private lateinit var loginSubject: Disposable
    private lateinit var registerSubject: Disposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginSubject = viewModel.loginSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { findNavController().navigate(R.id.action_loginFragment_to_mainFragment) }

        registerSubject = viewModel.registerSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }

        disposable.add(loginSubject)
        disposable.add(registerSubject)

        binding.vm = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.clear()
    }
}