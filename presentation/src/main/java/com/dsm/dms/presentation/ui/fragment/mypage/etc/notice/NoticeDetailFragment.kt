package com.dsm.dms.presentation.ui.fragment.mypage.etc.notice

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentNoticeDetailBinding
import com.dsm.dms.presentation.model.NoticeModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice.NoticeDetailViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice.NoticeDetailViewModelFactory
import javax.inject.Inject


class NoticeDetailFragment: DataBindingInjectFragment<FragmentNoticeDetailBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_notice_detail

    @Inject
    lateinit var factory: NoticeDetailViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(NoticeDetailViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        viewModel.notice.value = requireArguments().getParcelable<NoticeModel>("notice")
    }

    override fun observeEvent() {
        viewModel.backToList.observe(this, Observer {
            back()
        })
    }
}
