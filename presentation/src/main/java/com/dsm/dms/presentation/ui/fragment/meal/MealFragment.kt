package com.dsm.dms.presentation.ui.fragment.meal

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingInjectFragment
import com.dsm.dms.presentation.databinding.FragmentMealBinding
import com.dsm.dms.presentation.viewmodel.main.meal.MealViewModel
import com.dsm.dms.presentation.viewmodel.main.meal.MealViewModelFactory
import javax.inject.Inject
import kotlin.math.abs

class MealFragment: DataBindingInjectFragment<FragmentMealBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_meal

    @Inject
    lateinit var factory: MealViewModelFactory

    override val viewModel
            by lazy { ViewModelProvider(this, factory).get(MealViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        initMealPagerAnimation()
    }

    private fun initMealPagerAnimation() {
        binding.mealPager.setPageTransformer { page, position ->
            page.apply {
                translationY = abs(position) * 300f
                scaleX = 1f
                scaleY = 1f
            }
        }
        (binding.mealPager.getChildAt(0) as RecyclerView)
            .overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    override fun observeEvent() {

    }
}