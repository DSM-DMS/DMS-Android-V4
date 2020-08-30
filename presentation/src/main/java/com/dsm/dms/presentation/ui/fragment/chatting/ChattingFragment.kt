package com.dsm.dms.presentation.ui.fragment.chatting

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentChattingBinding
import com.dsm.dms.presentation.viewmodel.main.chatting.ChattingViewModel
import com.dsm.dms.presentation.viewmodel.main.chatting.ChattingViewModelFactory
import javax.inject.Inject

class ChattingFragment: DataBindingInjectFragment<FragmentChattingBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_chatting

    @Inject
    lateinit var factory: ChattingViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ChattingViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {

    }
}