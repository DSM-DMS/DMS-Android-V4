package com.dsm.dms.presentation.ui.fragment.mypage.etc.point

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentPointBinding
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.point.PointViewModel
import com.dsm.dms.presentation.viewmodel.main.mypage.etc.point.PointViewModelFactory
import kotlinx.android.synthetic.main.fragment_point.*
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
        viewModel.pointList.observe(this, Observer {
            point_list_rcv.layoutAnimation =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_from_right)
            point_list_rcv.scheduleLayoutAnimation()
        })

        viewModel.backToMyPageEvent.observe(this, Observer {
            back()
        })
    }
}
