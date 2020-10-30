package com.dsm.dms.presentation.ui.fragment.mypage.mydata

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentMypageMydataBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.mydata.MyPageMyDataViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.mydata.MyPageMyDataViewModelFactory
import javax.inject.Inject


class MyPageMyDataFragment: DataBindingInjectFragment<FragmentMypageMydataBinding>() {

    @Inject
    lateinit var factory: MyPageMyDataViewModelFactory

    override val layoutId: Int
        get() = R.layout.fragment_mypage_mydata

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(MyPageMyDataViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {

    }
}
