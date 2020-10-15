package com.dsm.dms.presentation.viewmodel.main.meal

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Meal
import com.dsm.dms.domain.usecase.GetMealUseCase
import com.dsm.dms.presentation.BR
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem
import com.dsm.dms.presentation.isNotNull
import com.dsm.dms.presentation.model.MealModel
import com.dsm.dms.presentation.model.VisibilityModel
import com.dsm.dms.presentation.model.toModel
import com.dsm.dms.presentation.onErrorShow
import io.reactivex.observers.DisposableSingleObserver
import java.text.SimpleDateFormat
import java.util.*


class MealViewModel(private val getMeal: GetMealUseCase): BaseViewModel() {
    val listItem =
        MutableLiveData<List<ViewPagerItem>>().apply { value = listOf() }
    val pageStatusLiveData = MutableLiveData<Int>().apply { postValue(6) }
    val dateText = Transformations.map(pageStatusLiveData) {
        getDateText(it)
    }

    val showMessageEvent = SingleLiveEvent<String>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> {
                addMealList()
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

        private fun onErrorGetMealData(result: Result.Error<Meal>) {
            if (result.data.isNotNull())
                onErrorGetMealDataIsNotNull(result)
            else
                onErrorGetMealDataIsNull(result)
        }

        private fun onErrorGetMealDataIsNotNull(result: Result.Error<Meal>) {
            showMessageGetMealData(result.message)
            visibility.visibleContent = View.VISIBLE
            meal = result.data!!.toModel()
        }

        private fun onErrorGetMealDataIsNull(result: Result.Error<Meal>) {
            showMessageGetMealData(result.message)
            visibility.visibleError = View.VISIBLE
            showImageGetMealData(result.message)
        }

        private fun showImageGetMealData(message: Message) {
            when (message) {
                Message.UNKNOW_ERROR ->
                    visibility.onErrorShow(R.drawable.ic_server_error)
                Message.NETWORK_ERROR ->
                    visibility.onErrorShow(R.drawable.ic_network_error)
                else ->
                    visibility.onErrorShow(R.drawable.ic_server_error)
            }
        }

        private fun showMessageGetMealData(message: Message) {
            when (message) {
                Message.UNKNOW_ERROR ->
                    showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
                Message.NETWORK_ERROR ->
                    showMessageEvent.value = "네트워크 오류가 발생했습니다"
                else ->
                    showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
            }
        }

        private fun onSuccessGetMealData(result: Result.Success<Meal>) {
            visibility.visibleContent = View.VISIBLE
            meal = result.data.toModel()
        }
    }

}
