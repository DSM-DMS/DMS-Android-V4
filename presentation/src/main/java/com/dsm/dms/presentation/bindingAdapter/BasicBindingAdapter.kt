package com.dsm.dms.presentation.bindingAdapter

import android.content.Context
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dsm.dms.presentation.adapter.RecyclerViewAdapter
import com.dsm.dms.presentation.adapter.ViewPagerAdapter
import com.dsm.dms.presentation.adapter.MealPagerAdapter
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.RecyclerViewAdapter
import com.dsm.dms.presentation.model.MealModel


@BindingAdapter("pageChange")
fun ViewPager2.setPageChange(data: MutableLiveData<Int>) {
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

@BindingAdapter("viewpagerItems")
fun ViewPager2.setViewPagerItems(
    items: List<ViewPagerItem>
) {
    if (adapter == null) {
        adapter = ViewPagerAdapter()
    }

    (adapter as? ViewPagerAdapter)?.updateData(items)

@BindingAdapter("mealItems")
fun ViewPager2.bindMealItems(mealItems: MutableLiveData<ArrayList<MealModel>>) {
    (adapter as MealPagerAdapter).setItem(mealItems)
}

@BindingAdapter("recyclerItems")
fun RecyclerView.setRecyclerViewItems(
    items: List<RecyclerItem>
) {
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        layoutManager = LinearLayoutManager(context)
    }

    (adapter as? RecyclerViewAdapter)?.updateData(items)
}
