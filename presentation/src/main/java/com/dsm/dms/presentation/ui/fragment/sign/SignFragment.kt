package com.dsm.dms.presentation.ui.fragment.sign

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.EndPointDataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentSignBinding
import com.dsm.dms.presentation.viewmodel.sign.SignViewModel
import com.dsm.dms.presentation.viewmodel.sign.SignViewModelFactory
import javax.inject.Inject

class SignFragment : EndPointDataBindingFragment<FragmentSignBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_sign

    @Inject
    lateinit var factory: SignViewModelFactory

    override val viewModel by lazy {
        ViewModelProviders.of(this, factory).get(SignViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }
}