package com.dsm.dms.presentation.ui.fragment.mypage.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.adapter.ViewPagerFragmentAdapter
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentMypageMainBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.main.MyPageMainViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.main.MyPageMainViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_mypage_main.*
import javax.inject.Inject


class MyPageMainFragment: DataBindingInjectFragment<FragmentMypageMainBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_mypage_main

    @Inject
    lateinit var factory: MyPageMainViewModelFactory

    @Inject
    lateinit var adapter: ViewPagerFragmentAdapter

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(MyPageMainViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        mypage_main_pager.adapter = adapter

        TabLayoutMediator(mypage_main_tap, mypage_main_pager) { tab, position ->
            mypage_main_pager.setCurrentItem(tab.position, true)
        }.attach()
    }

    override fun observeEvent() {

    }
}
