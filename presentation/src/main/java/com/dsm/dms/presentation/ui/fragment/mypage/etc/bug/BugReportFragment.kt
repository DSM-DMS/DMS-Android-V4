package com.dsm.dms.presentation.ui.fragment.mypage.etc.bug

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentBugReportBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.bug.BugReportViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.bug.BugReportViewModelFactory
import javax.inject.Inject


class BugReportFragment: DataBindingInjectFragment<FragmentBugReportBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_bug_report

    @Inject
    lateinit var factory: BugReportViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(BugReportViewModel::class.java) }

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
