package com.dsm.dms.presentation.ui.fragment.apply.music.detail


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.base.RecyclerViewAdapter
import com.dsm.dms.presentation.databinding.FragmentApplyMusicDayDetailListBinding
import com.dsm.dms.presentation.viewmodel.main.apply.music.detail.ApplyMusicDayDetailListViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.music.detail.ApplyMusicDayDetailListViewModelFactory
import kotlinx.android.synthetic.main.fragment_apply_music_day_detail_list.*
import javax.inject.Inject


class ApplyMusicDayDetailListFragment: DataBindingFragment<FragmentApplyMusicDayDetailListBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_music_day_detail_list

    @Inject
    lateinit var factory: ApplyMusicDayDetailListViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyMusicDayDetailListViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        viewModel.day.value = requireArguments().getString("day")
    }

    override fun observeEvent() {
        viewModel.backToListEvent.observe(this, Observer {
            back()
        })

        viewModel.setTitleEvent.observe(this, Observer {
            apply_music_day_detail_list_title_tv.text = it
        })

        viewModel.goToApplyEvent.observe(this, Observer {
            Navigation.findNavController(requireActivity(), R.id.fragment_container).navigate(
                R.id.action_mainFragment_to_applyMusicApplyFragment,
                Bundle().apply {
                    this.putString("day", viewModel.day.value)
                })
        })
    }
}
