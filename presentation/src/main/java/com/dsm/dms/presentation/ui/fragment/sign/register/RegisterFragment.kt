package com.dsm.dms.presentation.ui.fragment.sign.register

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentRegisterBinding
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class RegisterFragment : DataBindingFragment<FragmentRegisterBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_register

    @Inject
    lateinit var factory: RegisterViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(RegisterViewModel::class.java) }

    private val disposable = CompositeDisposable()

    private lateinit var backSubject: Disposable
    private lateinit var navController: NavController

    lateinit var navHost: Fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        navHost = fragmentManager?.findFragmentById(R.id.sign_container)!!

        backSubject =
            viewModel.backSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { requireActivity().onBackPressed() }

        disposable.add(backSubject)

        binding.vm = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.clear()
    }
}