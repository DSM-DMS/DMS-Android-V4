package com.dsm.dms.presentation.bindingAdapter

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dsm.dms.presentation.adapter.MealPagerAdapter
import com.dsm.dms.presentation.model.MealModel

@BindingAdapter("pageChange")
fun ViewPager2.setPageChange(data: MutableLiveData<Int>) {
    Log.d("MealBindingAdapter", "Page is $currentItem")
    if (currentItem != data.value)
        currentItem = data.value ?: 0
}

@InverseBindingAdapter(attribute = "pageChange")
fun ViewPager2.getPageChange(): Int {
    return currentItem
}

@BindingAdapter("pageChangeAttrChanged")
fun ViewPager2.setPageChangeListener(listener: InverseBindingListener) {
    registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            listener.onChange()
        }
    })
}

@BindingAdapter("mealItems")
fun ViewPager2.bindMealItems(mealItems: MutableLiveData<ArrayList<MealModel>>) {
    (adapter as MealPagerAdapter).setItem(mealItems)
}