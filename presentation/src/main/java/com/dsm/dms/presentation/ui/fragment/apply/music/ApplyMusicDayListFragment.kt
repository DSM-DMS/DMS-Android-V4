package com.dsm.dms.presentation.ui.fragment.apply.music

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentApplyMusicDayListBinding
import com.dsm.dms.presentation.viewmodel.main.apply.music.ApplyMusicDayListViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.music.ApplyMusicDayListViewModelFactory
import javax.inject.Inject


class ApplyMusicDayListFragment: DataBindingFragment<FragmentApplyMusicDayListBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_music_day_list

    @Inject
    lateinit var factory: ApplyMusicDayListViewModelFactory

    override val viewModel: ApplyMusicDayListViewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyMusicDayListViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.goDetailDayEvent.observe(this, Observer {
            findNavController().navigate(
                R.id.action_applyMusicDayListFragment_to_applyMusicDayDetailListFragment,
                Bundle().apply {
                    this.putString("day", it)
                }
            )
        })

        viewModel.backToMain.observe(this, Observer {
            back()
        })
    }
}
