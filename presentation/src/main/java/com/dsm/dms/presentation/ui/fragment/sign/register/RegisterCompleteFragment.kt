package com.dsm.dms.presentation.ui.fragment.sign.register

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentRegisterCompleteBinding
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterCompleteViewModel
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterCompleteViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class RegisterCompleteFragment : DataBindingFragment<FragmentRegisterCompleteBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_register_complete

    @Inject
    lateinit var factory: RegisterCompleteViewModelFactory

    override val viewModel by lazy {
        ViewModelProviders.of(this, factory).get(RegisterCompleteViewModel::class.java)
    }

    private lateinit var completeSubject: Disposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backPressedGoToMain()

        completeSubject = viewModel.completeSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { findNavController().navigate(R.id.action_registerCompleteFragment_to_mainFragment) }

        binding.vm = viewModel
    }

    private fun backPressedGoToMain() {
        requireActivity().onBackPressedDispatcher.addCallback(
            this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_registerCompleteFragment_to_mainFragment)
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        completeSubject.dispose()
    }
}