package com.dsm.dms.presentation.ui.fragment.sign.register.account.certify

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentCertifyAccountBinding
import com.dsm.dms.presentation.ui.fragment.sign.register.RegisterFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class CertifyAccountFragment : DataBindingFragment<FragmentCertifyAccountBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_certify_account

    @Inject
    lateinit var registerFragment: RegisterFragment

    override val viewModel by lazy {
        registerFragment.viewModel
    }

    private lateinit var certifyDisposable: Disposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        certifyDisposable = viewModel.nextSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                registerFragment.findNavController().navigate(R.id.action_registerFragment_to_registerCompleteFragment)
                certifyDisposable.dispose()
            }

        binding.vm = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        certifyDisposable.dispose()
    }
}