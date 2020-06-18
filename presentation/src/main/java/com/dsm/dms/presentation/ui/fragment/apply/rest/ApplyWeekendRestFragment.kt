package com.dsm.dms.presentation.ui.fragment.apply.rest

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.changeContentCardColor
import com.dsm.dms.presentation.databinding.FragmentApplyWeekendRestBinding
import com.dsm.dms.presentation.originContentCardColor
import com.dsm.dms.presentation.viewmodel.main.apply.rest.ApplyWeekendRestViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.rest.ApplyWeekendRestViewModelFactory
import kotlinx.android.synthetic.main.fragment_apply_weekend_rest.*
import javax.inject.Inject

class ApplyWeekendRestFragment: DataBindingInjectFragment<FragmentApplyWeekendRestBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_weekend_rest

    @Inject
    lateinit var factory: ApplyWeekendRestViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(ApplyWeekendRestViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.weekendRestClickEvent.observe(this, Observer {
            when (viewModel.nowWeekendRest.value) {
                "am" -> resources.originContentCardColor(
                    apply_weekend_rest_am_card,
                    apply_weekend_rest_am_title_tv,
                    apply_weekend_rest_am_content_tv
                )
                "pm" -> resources.originContentCardColor(
                    apply_weekend_rest_pm_card,
                    apply_weekend_rest_pm_title_tv,
                    apply_weekend_rest_pm_content_tv
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
            "am" -> resources.changeContentCardColor(
                apply_weekend_rest_am_card,
                apply_weekend_rest_am_title_tv,
                apply_weekend_rest_am_content_tv
            )
            "pm" -> resources.changeContentCardColor(
                apply_weekend_rest_pm_card,
                apply_weekend_rest_pm_title_tv,
                apply_weekend_rest_pm_content_tv
            )
        }
        viewModel.nowWeekendRest.value = cardText
    }
}
