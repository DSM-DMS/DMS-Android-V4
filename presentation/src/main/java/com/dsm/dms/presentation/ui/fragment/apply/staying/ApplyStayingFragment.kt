package com.dsm.dms.presentation.ui.fragment.apply.staying

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionInflater
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.changeContentCardColor
import com.dsm.dms.presentation.databinding.FragmentApplyStayingBinding
import com.dsm.dms.presentation.originContentCardColor
import com.dsm.dms.presentation.viewmodel.main.apply.staying.ApplyStayingViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.staying.ApplyStayingViewModelFactory
import kotlinx.android.synthetic.main.fragment_apply_staying.*
import javax.inject.Inject

class ApplyStayingFragment: DataBindingInjectFragment<FragmentApplyStayingBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_staying

    @Inject
    lateinit var factory: ApplyStayingViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyStayingViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.cardChangeColorEvent.observe(this, Observer {
            when (viewModel.nowStayingState.value) {
                "금요귀가" -> resources.originContentCardColor(
                    apply_staying_friday_go_card,
                    apply_staying_friday_go_title_tv,
                    apply_staying_friday_go_content_tv
                )
                "토요귀가" -> resources.originContentCardColor(
                    apply_staying_saturday_go_card,
                    apply_staying_saturday_go_title_tv,
                    apply_staying_saturday_go_content_tv
                )
                "토요귀사" -> resources.originContentCardColor(
                    apply_staying_saturday_back_card,
                    apply_staying_saturday_back_title_tv,
                    apply_staying_saturday_back_content_tv
                )
                "잔류" -> resources.originContentCardColor(
                    apply_staying_staying_card,
                    apply_staying_staying_title_tv,
                    apply_staying_staying_content_tv
                )
            }
            searchCard(it)
        })

        viewModel.backToMainEvent.observe(this, Observer {
            back()
        })
    }

    private fun searchCard(cardText: String) {
        when(cardText) {
            "금요귀가" -> resources.changeContentCardColor(
                apply_staying_friday_go_card,
                apply_staying_friday_go_title_tv,
                apply_staying_friday_go_content_tv
            )
            "토요귀가" -> resources.changeContentCardColor(
                apply_staying_saturday_go_card,
                apply_staying_saturday_go_title_tv,
                apply_staying_saturday_go_content_tv
            )
            "토요귀사" -> resources.changeContentCardColor(
                apply_staying_saturday_back_card,
                apply_staying_saturday_back_title_tv,
                apply_staying_saturday_back_content_tv
            )
            "잔류" -> resources.changeContentCardColor(
                apply_staying_staying_card,
                apply_staying_staying_title_tv,
                apply_staying_staying_content_tv
            )
        }
        viewModel.nowStayingState.value = cardText
    }
}