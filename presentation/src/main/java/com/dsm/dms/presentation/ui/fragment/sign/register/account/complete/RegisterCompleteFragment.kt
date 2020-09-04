package com.dsm.dms.presentation.ui.fragment.sign.register.account.complete

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.navigation.Navigation
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentRegisterCompleteBinding
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import javax.inject.Inject

class RegisterCompleteFragment : DataBindingInjectFragment<FragmentRegisterCompleteBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_register_complete

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

    }
}