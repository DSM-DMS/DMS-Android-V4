package com.dsm.dms.presentation.ui.fragment.mypage.etc.setting

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentSettingBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.setting.SettingViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.setting.SettingViewModelFactory
import javax.inject.Inject


class SettingFragment: DataBindingInjectFragment<FragmentSettingBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_setting

    @Inject
    lateinit var factory: SettingViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(SettingViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {
        viewModel.backToMyPageEvent.observe(this, Observer {
            back()
        })
    }
}
