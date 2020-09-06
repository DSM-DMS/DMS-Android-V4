package com.dsm.dms.presentation.ui.fragment.mypage.etc.change

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentChangePasswordBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.change.ChangePasswordViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.change.ChangePasswordViewModelFactory
import kotlinx.android.synthetic.main.fragment_change_password.*
import javax.inject.Inject


class ChangePasswordFragment: DataBindingInjectFragment<FragmentChangePasswordBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_change_password

    @Inject
    lateinit var factory: ChangePasswordViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ChangePasswordViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {
        viewModel.backToMyPageEvent.observe(this, Observer {
            back()
        })
        viewModel.onLoadEvent.observe(this, Observer {
            change_password_change_btn.onLoad(it)
        })
        viewModel.onSuccessEvent.observe(this, Observer {
            change_password_change_btn.onSuccess(it)
        })
        viewModel.onErrorEvent.observe(this, Observer {
            change_password_change_btn.onError(it)
        })
    }
}
