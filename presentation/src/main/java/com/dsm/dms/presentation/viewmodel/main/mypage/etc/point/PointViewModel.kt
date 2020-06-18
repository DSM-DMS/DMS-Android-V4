package com.dsm.dms.presentation.viewmodel.main.mypage.etc.point

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.presentation.BR
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.RecyclerItem
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem
import com.dsm.dms.presentation.model.PointModel


class PointViewModel: BaseViewModel() {

    val pointList = MutableLiveData<List<RecyclerItem>>()

    val backToMyPageEvent = SingleLiveEvent<Unit>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_START -> {
                loadData(
                    arrayListOf(
                        PointModel("앙", "2020-6-16", "30", true),
                        PointModel("앙", "2020-6-16", "30", true),
                        PointModel("앙", "2020-6-16", "30", false)
                    )
                )
            }
        }
    }

    fun backClick() = backToMyPageEvent.call()

    private fun loadData(points: List<PointModel>) {
        pointList.value = points.map { PointItemViewModel(it) }
            .map { it.toRecyclerItem() }
    }

    private fun PointItemViewModel.toRecyclerItem() =
        RecyclerItem(
            data = this,
            variableId = BR.vm,
            layoutId = R.layout.item_point
        )

}

class PointItemViewModel(val point: PointModel)
