package com.dsm.dms.presentation.ui.fragment.main.mypage

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentMypageBinding
import com.dsm.dms.presentation.viewmodel.main.MyPageViewModel
import com.dsm.dms.presentation.viewmodel.main.MyPageViewModelFactory
import javax.inject.Inject

class MyPageFragment: DataBindingFragment<FragmentMypageBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_mypage

    @Inject
    lateinit var factory: MyPageViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(MyPageViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }
}