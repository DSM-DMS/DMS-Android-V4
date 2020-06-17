package com.dsm.dms.presentation.ui.fragment.apply.music.apply

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentApplyMusicApplyBinding
import com.dsm.dms.presentation.viewmodel.main.apply.music.apply.ApplyMusicApplyViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.music.apply.ApplyMusicApplyViewModelFactory
import javax.inject.Inject


class ApplyMusicApplyFragment: DataBindingFragment<FragmentApplyMusicApplyBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_music_apply

    @Inject
    lateinit var factory: ApplyMusicApplyViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyMusicApplyViewModel::class.java) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback {
            back()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        viewModel.day.value = requireArguments().getString("day")
    }

    override fun observeEvent() {
        viewModel.backToDetailListEvent.observe(this, Observer {
            back()
        })
    }
}
