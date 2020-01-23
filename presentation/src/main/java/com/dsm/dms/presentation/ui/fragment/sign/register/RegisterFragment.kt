package com.dsm.dms.presentation.ui.fragment.sign.register

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentRegisterBinding
import com.dsm.dms.presentation.viewmodel.sign.register.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import javax.inject.Inject

class RegisterFragment : DataBindingFragment<FragmentRegisterBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_register

    @Inject
    override lateinit var viewModel: RegisterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        val navHost = fragmentManager?.findFragmentById(R.id.sign_container)!!

        viewModel.backSingleLiveEvent
            .observe(this, Observer {
                requireActivity().onBackPressed()
            })

        viewModel.nextSingleLiveEvent
            .observe(this, Observer {
                navHost.childFragmentManager.primaryNavigationFragment.let {
                    val navController = it?.findNavController()

                    when (navController?.currentDestination?.label) {
                        "CreateAccountFragment" -> {
                            navController.navigate(R.id.action_createAccountFragment_to_certifyAccountFragment)
                        }
                        "CertifyAccountFragment" -> {
                            navController.navigate(R.id.action_certifyAccountFragment_to_registerCompleteFragment)

                            register_back_img.visibility = View.GONE
                            register_next_btn.visibility = View.GONE

                            register_complete_btn.visibility = View.VISIBLE

                            backPressedGoToMain()
                        }
                    }
                }
            })

        viewModel.completeSingleLiveEvent
            .observe(this, Observer {
                findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
            })
    }

    private fun backPressedGoToMain() {
        requireActivity().onBackPressedDispatcher.addCallback(
            this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
                }
            })
    }
}