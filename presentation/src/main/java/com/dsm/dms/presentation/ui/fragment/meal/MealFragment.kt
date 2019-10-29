package com.dsm.dms.presentation.ui.fragment.meal

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.DataBindingFragment
import com.dsm.dms.presentation.databinding.FragmentMealBinding
import com.dsm.dms.presentation.viewmodel.main.MealViewModel
import com.dsm.dms.presentation.viewmodel.main.MealViewModelFactory
import javax.inject.Inject

class MealFragment: DataBindingFragment<FragmentMealBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_meal

    @Inject
    lateinit var factory: MealViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(MealViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }
}