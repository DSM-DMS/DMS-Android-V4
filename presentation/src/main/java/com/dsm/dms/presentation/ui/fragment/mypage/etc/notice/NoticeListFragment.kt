package com.dsm.dms.presentation.ui.fragment.mypage.etc.notice

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentNoticeListBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice.NoticeListViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.notice.NoticeListViewModelFactory
import javax.inject.Inject


class NoticeListFragment: DataBindingInjectFragment<FragmentNoticeListBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_notice_list

    @Inject
    lateinit var factory: NoticeListViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(NoticeListViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {
        viewModel.backToMyPageEvent.observe(this, Observer {
            back()
        })

        viewModel.goToDetailEvent.observe(this, Observer {
            findNavController().navigate(
                R.id.action_noticeListFragment_to_noticeDetailFragment,
                Bundle().apply {
                    putString("title", it.title)
                    putString("content", it.content)
                    putString("date", it.date)
                    putString("viewCount", it.viewCount)
                }
            )
        })
    }
}
