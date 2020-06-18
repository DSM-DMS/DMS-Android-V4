package com.dsm.dms.presentation.viewmodel.main.meal

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.dsm.dms.presentation.BR
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem
import com.dsm.dms.presentation.model.MealModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MealViewModel: BaseViewModel() {
    val listItem = MutableLiveData<List<ViewPagerItem>>()

    val pageStatusLiveData = MutableLiveData<Int>()

    val dateText = Transformations.map(pageStatusLiveData){
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, it)
        SimpleDateFormat("yyyy년 MM월 dd일 EEEE", Locale.KOREA).format(calendar.time)
    }

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_START -> {
                loadData(
                    arrayListOf(
                        MealModel("기본값", "기본값", "기본값"),
                        MealModel("기본값", "기본값", "기본값"),
                        MealModel("기본값", "기본값", "기본값"),
                        MealModel("기본값", "기본값", "기본값")
                    )
                )

            }
        }
    }

    fun dateBeforeClick() {
        if (pageStatusLiveData.value!! > 0)
            pageStatusLiveData.value = pageStatusLiveData.value!! - 1
    }

    fun dateAfterClick() {
        if (pageStatusLiveData.value!! < listItem.value!!.size - 1)
            pageStatusLiveData.value = pageStatusLiveData.value!! + 1
    }

    private fun loadData(meals: ArrayList<MealModel>) {
        listItem.value = meals.map { it.toViewPagerItem() }
    }

    private fun MealModel.toViewPagerItem() =
        ViewPagerItem(
            data = this,
            variableId = BR.meal,
            layoutId = R.layout.item_meal
        )
}