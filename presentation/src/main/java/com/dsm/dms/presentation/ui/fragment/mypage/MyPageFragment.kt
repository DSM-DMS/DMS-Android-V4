package com.dsm.dms.presentation.ui.fragment.mypage

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentMypageBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.MyPageViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.MyPageViewModelFactory
import javax.inject.Inject

class MyPageFragment: DataBindingInjectFragment<FragmentMypageBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_mypage

    @Inject
    lateinit var factory: MyPageViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(MyPageViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {

    }
}
