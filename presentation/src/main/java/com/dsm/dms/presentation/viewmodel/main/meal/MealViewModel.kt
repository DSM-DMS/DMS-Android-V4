package com.dsm.dms.presentation.viewmodel.main.meal

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem
import com.dsm.dms.presentation.model.MealModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MealViewModel: BaseViewModel() {
    val mealItems = MutableLiveData<ArrayList<MealModel>>().apply {
        value = ArrayList()
        value!!.add(MealModel("기본값", "기본값", "기본값"))
        value!!.add(MealModel("기본값", "기본값", "기본값"))
        value!!.add(MealModel("기본값", "기본값", "기본값"))
        value!!.add(MealModel("기본값", "기본값", "기본값"))
    }

    val pageStatusLiveData = MutableLiveData<Int>()

    val dateText = Transformations.map(pageStatusLiveData){
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, it)
        SimpleDateFormat("yyyy년 MM월 dd일 EEEE", Locale.KOREA).format(calendar.time)
    }

    val showMessageEvent = SingleLiveEvent<String>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun dateBeforeClick() {
        if (pageStatusLiveData.value!! > 0)
            pageStatusLiveData.value = pageStatusLiveData.value!! - 1
    }

    fun dateAfterClick() {
        if (pageStatusLiveData.value!! < mealItems.value!!.size - 1)
            pageStatusLiveData.value = pageStatusLiveData.value!! + 1
    }

    private fun getDateText(status: Int): String {
        val calendar = Calendar.getInstance()

        return SimpleDateFormat("yyyy년 MM월 dd일 EEEE", Locale.KOREA).format(
            calendar.apply {
                add(Calendar.DAY_OF_YEAR, status - 6)
            }.time
        )
    }

    private fun addMealList() {
        val calender = Calendar.getInstance()

        calender.add(Calendar.DAY_OF_YEAR, -7)
        val meals = arrayListOf<MealModel>().apply {
            repeat((0..20).count()) {
                add(createMeal(calender))
            }
        }

        loadData(meals)
    }

    private fun createMeal(mealCalendar: Calendar): MealModel {
        mealCalendar.add(Calendar.DAY_OF_YEAR, 1)

        return MealModel(
            date = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(mealCalendar.time)
        )
    }

    private fun loadData(meals: List<MealModel>) {
        listItem.value = meals.map {
            MealItemViewModel(it, VisibilityModel()).toViewPagerItem()
        }
    }

    private fun MealItemViewModel.toViewPagerItem() =
        ViewPagerItem(
            data = this,
            variableId = BR.vm,
            layoutId = R.layout.item_meal
        )

    inner class MealItemViewModel(
        var meal: MealModel,
        val visibility: VisibilityModel
    ) {

        init {
            getMealData(meal.date)
        }

        private fun getMealData(date: String) {
            visibility.visibleLoad = View.VISIBLE
            getMeal.execute(date, object: DisposableSingleObserver<Result<Meal>>() {
                override fun onSuccess(result: Result<Meal>) {
                    when(result) {
                        is Result.Success ->
                            onSuccessGetMealData(result)
                        is Result.Error ->
                            onErrorGetMealData(result)
                    }
                    visibility.visibleLoad = View.GONE
                }

                override fun onError(e: Throwable) {
                    visibility.visibleLoad = View.GONE
                }
            })
        }

        private fun onErrorShow(resource: Int) {
            visibility.errorResource = resource
            visibility.visibleContent = View.GONE
            visibility.visibleError = View.VISIBLE
        }

        private fun onSuccessShow() {
            visibility.visibleContent = View.VISIBLE
        }

        private fun onErrorGetMealData(result: Result.Error<Meal>) {
            if (result.data != null) {
                when (result.message) {
                    Message.UNKNOW_ERROR ->
                        showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
                    Message.NETWORK_ERROR ->
                        showMessageEvent.value = "네트워크 오류가 발생했습니다"
                    else ->
                        showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
                }
                meal = result.data!!.toModel()
                visibility.visibleContent = View.VISIBLE
            } else {
                when (result.message) {
                    Message.UNKNOW_ERROR ->
                        onErrorShow(R.drawable.ic_server_error)
                    Message.NETWORK_ERROR ->
                        onErrorShow(R.drawable.ic_network_error)
                    else ->
                        onErrorShow(R.drawable.ic_server_error)
                }
            }
        }

        private fun onSuccessGetMealData(result: Result.Success<Meal>) {
            onSuccessShow()
            meal = result.data.toModel()
        }
    }

}
