package com.dsm.dms.presentation.ui.fragment.apply.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentApplyMainBinding
import com.dsm.dms.presentation.viewmodel.main.apply.main.ApplyMainViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.main.ApplyMainViewModelFactory
import kotlinx.android.synthetic.main.fragment_apply_main.*
import javax.inject.Inject

class ApplyMainFragment: DataBindingInjectFragment<FragmentApplyMainBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_main

    @Inject
    lateinit var factory: ApplyMainViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyMainViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.goStayingEvent.observe(this, Observer {
            val extras = FragmentNavigatorExtras(
                apply_main_staying_imv to "stayingImageView"
            )
            findNavController().navigate(
                R.id.action_applyMainFragment_to_applyStayingFragment,
                null, null, extras)
        })
        viewModel.goStudyingEvent.observe(this, Observer {
            val extras = FragmentNavigatorExtras(
                apply_main_studying_imv to "studyImageView"
            )
            findNavController().navigate(
                R.id.action_applyMainFragment_to_applyExtensionFloorListFragment,
                null, null, extras)

        })
        viewModel.goGoingOutEvent.observe(this, Observer {

        })
        viewModel.goMusicEvent.observe(this, Observer{
            val extras = FragmentNavigatorExtras(
                apply_main_music_imv to "musicImageView"
            )
            findNavController().navigate(
                R.id.action_applyMainFragment_to_applyMusicDayListFragment,
                null, null, extras)
        })
        viewModel.goRestEvent.observe(this, Observer {
            val extras = FragmentNavigatorExtras(
                apply_main_rest_imv to "restImageView"
            )
            findNavController().navigate(
                R.id.action_applyMainFragment_to_applyWeekendRestFragment,
                null, null, extras)
        })
    }
}