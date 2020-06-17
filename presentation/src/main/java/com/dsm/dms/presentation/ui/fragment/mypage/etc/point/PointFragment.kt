package com.dsm.dms.presentation.ui.fragment.mypage.etc.point

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentPointBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.point.PointViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.point.PointViewModelFactory
import javax.inject.Inject


class PointFragment: DataBindingInjectFragment<FragmentPointBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_point

    @Inject
    lateinit var factory: PointViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(PointViewModel::class.java) }

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
