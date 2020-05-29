package com.dsm.dms.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dsm.dms.presentation.BR
import com.dsm.dms.presentation.databinding.ItemMealBinding
import com.dsm.dms.presentation.model.MealModel
import com.dsm.dms.presentation.viewmodel.main.meal.MealViewModel

class MealPagerAdapter(private val viewModel: MealViewModel): RecyclerView.Adapter<MealPagerAdapter.MealPagerViewHoder>() {

    private var mealItems = ArrayList<MealModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPagerViewHoder {
        val binding
                = ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.vm = viewModel
        return MealPagerViewHoder(binding)
    }

    override fun getItemCount(): Int = mealItems.size

    override fun onBindViewHolder(holder: MealPagerViewHoder, position: Int)
            = holder.bind(mealItems[position])

    fun setItem(mealItems: MutableLiveData<ArrayList<MealModel>>) {
        this.mealItems = mealItems.value!!
        notifyDataSetChanged()
    }

    class MealPagerViewHoder(val binding: ItemMealBinding): RecyclerView.ViewHolder(binding.root.rootView) {
        fun bind(meal: MealModel) {
            binding.setVariable(BR.meal, meal)
        }
    }
}