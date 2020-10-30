package com.dsm.dms.presentation.ui.fragment.mypage.etc

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentMypageEtcBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.MyPageEtcViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.MyPageEtcViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject


class MyPageEtcFragment: DataBindingInjectFragment<FragmentMypageEtcBinding>() {

    @Inject
    lateinit var factory: MyPageEtcViewModelFactory

    override val layoutId: Int
        get() = R.layout.fragment_mypage_etc

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(MyPageEtcViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {
        with(viewModel) {
            goBugReportEvent.observe(this@MyPageEtcFragment, Observer {
                Navigation.findNavController(requireActivity(), R.id.fragment_container).navigate(
                    R.id.action_mainFragment_to_bugReportFragment
                )
            })

            goChangePasswordEvent.observe(this@MyPageEtcFragment, Observer {
                Navigation.findNavController(requireActivity(), R.id.fragment_container).navigate(
                    R.id.action_mainFragment_to_changePasswordFragment
                )
            })

            goPointEvent.observe(this@MyPageEtcFragment, Observer {
                Navigation.findNavController(requireActivity(), R.id.fragment_container).navigate(
                    R.id.action_mainFragment_to_pointFragment
                )
            })

            goNoticeEvent.observe(this@MyPageEtcFragment, Observer {
                Navigation.findNavController(requireActivity(), R.id.mypage_container).navigate(
                    R.id.action_myPageMainFragment_to_noticeListFragment
                )
            })

            goSettingEvent.observe(this@MyPageEtcFragment, Observer {
                Navigation.findNavController(requireActivity(), R.id.mypage_container).navigate(
                    R.id.action_myPageMainFragment_to_settingFragment
                )
            })

            createLogoutDialogEvent.observe(this@MyPageEtcFragment, Observer {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle(getString(R.string.logout_dialog_title))
                    .setMessage(getString(R.string.logout_dialog_content))
                    .setPositiveButton(resources.getString(R.string.logout_dialog_okay)) { dialog, which ->

                    }
                    .setNegativeButton(resources.getString(R.string.logout_dialog_no)) { dialog, which ->

                    }
                    .show()
            })
        }
    }
}
