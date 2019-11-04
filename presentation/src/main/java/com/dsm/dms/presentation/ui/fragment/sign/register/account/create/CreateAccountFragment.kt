package com.dsm.dms.presentation.ui.fragment.sign.register.account.create

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentCreateAccountBinding
import com.dsm.dms.presentation.ui.fragment.sign.register.RegisterFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class CreateAccountFragment : DataBindingFragment<FragmentCreateAccountBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_create_account

    @Inject
    lateinit var registerFragment: RegisterFragment

    override val viewModel by lazy {
        registerFragment.viewModel
    }

    private lateinit var createDisposable: Disposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createDisposable = viewModel.nextSubject
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                findNavController().navigate(R.id.action_createAccountFragment_to_certifyAccountFragment)
                createDisposable.dispose()
            }

        binding.vm = registerFragment.viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        createDisposable.dispose()
    }
}