package com.dsm.dms.presentation.ui.fragment.apply.staying

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentApplyStayingBinding
import com.dsm.dms.presentation.viewmodel.main.apply.staying.ApplyStayingViewModel
import com.dsm.dms.presentation.viewmodel.main.apply.staying.ApplyStayingViewModelFactory
import kotlinx.android.synthetic.main.fragment_apply_staying.*
import org.jetbrains.anko.textColor
import javax.inject.Inject

class ApplyStayingFragment: DataBindingFragment<FragmentApplyStayingBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_staying

    @Inject
    lateinit var factory: ApplyStayingViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(ApplyStayingViewModel::class.java) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(
            this, object: OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    backToMain()
                }
            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.cardChangeColorEvent.observe(this, Observer {
            when (viewModel.nowStayingState.value) {
                "금요귀가" -> originalColor(apply_staying_friday_go_card,
                    apply_staying_friday_go_title_tv, apply_staying_friday_go_content_tv)
                "토요귀가" -> originalColor(apply_staying_saturday_go_card,
                    apply_staying_saturday_go_title_tv, apply_staying_saturday_go_content_tv)
                "토요귀사" -> originalColor(apply_staying_saturday_back_card,
                    apply_staying_saturday_back_title_tv, apply_staying_saturday_back_content_tv)
                "잔류" -> originalColor(apply_staying_staying_card,
                    apply_staying_staying_title_tv, apply_staying_staying_content_tv)
            }
            searchCard(it)
        })

        viewModel.backToMainEvent.observe(this, Observer {
            backToMain()
        })
    }

    private fun backToMain()
            = findNavController().navigate(R.id.action_applyStayingFragment_to_applyMainFragment)

    private fun searchCard(cardText: String) {
        when(cardText) {
            "금요귀가" -> changeColor(apply_staying_friday_go_card,
                apply_staying_friday_go_title_tv, apply_staying_friday_go_content_tv)
            "토요귀가" -> changeColor(apply_staying_saturday_go_card,
                apply_staying_saturday_go_title_tv, apply_staying_saturday_go_content_tv)
            "토요귀사" -> changeColor(apply_staying_saturday_back_card,
                apply_staying_saturday_back_title_tv, apply_staying_saturday_back_content_tv)
            "잔류" -> changeColor(apply_staying_staying_card,
                apply_staying_staying_title_tv, apply_staying_staying_content_tv)
        }
        viewModel.nowStayingState.value = cardText
    }

    private fun changeColor(card: CardView, title: AppCompatTextView, content: AppCompatTextView) {
        card.setCardBackgroundColor(
            ContextCompat.getColor(context!!, R.color.colorMain))
        title.textColor = ContextCompat.getColor(context!!, R.color.colorWhite)
        content.textColor = ContextCompat.getColor(context!!, R.color.colorWhite)
    }

    private fun originalColor(card: CardView, title: AppCompatTextView, content: AppCompatTextView) {
        card.setCardBackgroundColor(
            ContextCompat.getColor(context!!, R.color.colorNightViewBackgroundDefault))
        title.textColor = ContextCompat.getColor(context!!, R.color.colorNightBlack)
        content.textColor = ContextCompat.getColor(context!!, R.color.colorNightViewColorDefault)
    }
}