package com.dsm.dms.presentation.viewmodel.main.apply.extension.detail

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.entity.Map
import com.dsm.dms.domain.entity.enums.ClassNum
import com.dsm.dms.domain.isNotNull
import com.dsm.dms.domain.usecase.GetExtensionMapUseCase
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.isNotNull
import io.reactivex.observers.DisposableSingleObserver
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.usecase.ApplyExtensionUseCase
import com.dsm.dms.presentation.R
import com.dsm.dms.presentation.model.*
import com.dsm.dms.presentation.onErrorShow
import com.dsm.dms.presentation.updateVisibility


class ApplyExtensionFloorDetailViewModel(
    private val getExtensionMapUseCase: GetExtensionMapUseCase,
    private val applyExtensionUseCase: ApplyExtensionUseCase
): BaseViewModel() {

    val backToListEvent = SingleLiveEvent<Unit>()
    val setTitleEvent = SingleLiveEvent<Int>()
    val changeNewClassEvent = SingleLiveEvent<ClassNum>()
    val changeOldClassEvent = SingleLiveEvent<ClassNum>()

    val elevenClockEvent = SingleLiveEvent<Unit>()
    val twelveClockEvent = SingleLiveEvent<Unit>()

    val changeMapEvent = SingleLiveEvent<List<List<Any>>>()
    val showMessageEvent = SingleLiveEvent<String>()

    val onLoadEvent = SingleLiveEvent<String>()
    val onErrorEvent = SingleLiveEvent<String>()
    val onSuccessEvent = SingleLiveEvent<String>()

    val nowFloor = MutableLiveData<Int>()
    val selectedClassNum = MutableLiveData<ClassNum>()
    val selectedClock = MutableLiveData<Int>()
    val selectedSeatNum = MutableLiveData<Int>()
    val visibility =
        MutableLiveData<VisibilityModel>().apply {
            value = VisibilityModel(visibleLoad = View.GONE)
        }

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> {
                setTitleEvent.value = nowFloor.value
            }
        }
    }

    fun clockClick(time: Int) {
        when(time) {
            11 -> elevenClockClick()
            12 -> twelveClockClick()
        }
        setExtensionMap()
    }

    fun backClick() = backToListEvent.call()

    fun classClick(classNum: ClassNum) {
        selectedSeatNum.value = null
        changeClassNum(classNum)
        setExtensionMap()
    }

    fun applyClick() {
        onLoadEvent.value = "연장신청 중"
        if (checkApplyExtensionInput()) {
            applyExtension()
        } else {
            onErrorEvent.value = "좌석을 선택해주세요"
        }
    }

    private fun changeClassNum(classNum: ClassNum) {
        selectedClassNum.value?.let {
            if (classNum != it) {
                changeOldClassEvent.value = it
            }
        }
        selectedClassNum.value = classNum
        changeNewClassEvent.value = classNum
    }

    private fun elevenClockClick() {
        elevenClockEvent.call()
        selectedClock.value = 11
    }

    private fun twelveClockClick() {
        twelveClockEvent.call()
        selectedClock.value = 12
    }

    private fun setExtensionMap() {
        visibility.updateVisibility {
            it.visibleLoad = View.VISIBLE
        }
        if (checkGetExtensionMapInput()) {
            getExtensionMap()
        } else {
            showMessageEvent.value = "연장신청 시각과 장소를 모두 선택해주세요"
            visibility.updateVisibility {
                it.visibleLoad = View.GONE
            }
        }
    }

    private fun applyExtension() {
        applyExtensionUseCase.execute(
            createExtensionInfoModel().toEntity(), object: DisposableSingleObserver<Result<Unit>>() {
                override fun onSuccess(result: Result<Unit>) {
                    when(result) {
                        is Result.Success ->
                            onSuccessApplyExtension(result)
                        is Result.Error ->
                            onErrorApplyExtension(result)
                    }
                }

                override fun onError(e: Throwable) {
                    onErrorEvent.value = "알 수 없는 오류가 발생했습니다"
                }
            }
        )
    }

    private fun getExtensionMap() {
        getExtensionMapUseCase.execute(
            createRoomModel().toObject(), object: DisposableSingleObserver<Result<Map>>() {
                override fun onSuccess(result: Result<Map>) {
                    when(result) {
                        is Result.Success ->
                            onSuccessGetExtensionMap(result)
                        is Result.Error ->
                            onErrorGetExtensionMap(result)
                    }
                }

                override fun onError(e: Throwable) {

                }
            }
        )
    }

    private fun onSuccessApplyExtension(result: Result.Success<Unit>) {
        onSuccessEvent.value = "연장신청 성공"
    }

    private fun onErrorApplyExtension(result: Result.Error<Unit>) {
        when(result.message) {
            Message.SERVER_ERROR ->
                onErrorEvent.value = "서버 오류가 발생했습니다"
            Message.NETWORK_ERROR ->
                onErrorEvent.value = "네트워크 오류가 발생했습니다"
            Message.UNKNOW_ERROR ->
                onErrorEvent.value = "알 수 없는 오류가 발생했습니다"
            else ->
                onErrorEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

    private fun onSuccessGetExtensionMap(result: Result.Success<Map>) {
        changeMapEvent.value = result.data.map
        visibility.updateVisibility {
            it.visibleLoad = View.GONE
            it.visibleContent = View.VISIBLE
        }
    }

    private fun onErrorGetExtensionMap(result: Result.Error<Map>) {
        if (result.data.isNotNull())
            onErrorGetExtensionMapIsNotNull(result)
        else
            onErrorGetExtensionMapIsNull(result)
    }

    private fun onErrorGetExtensionMapIsNotNull(result: Result.Error<Map>) {
        showMessageGetExtensionMap(result.message)
        visibility.updateVisibility {
            it.visibleLoad = View.GONE
            it.visibleContent = View.VISIBLE
        }
        changeMapEvent.value = result.data!!.map
    }

    private fun showImageGetExtensionMap(message: Message) {
        when(message) {
            Message.NETWORK_ERROR ->
                visibility.updateVisibility {
                    it.onErrorShow(R.drawable.ic_network_error)
                }
            Message.SERVER_ERROR ->
                visibility.updateVisibility {
                    it.onErrorShow(R.drawable.ic_server_error)
                }
            Message.UNKNOW_ERROR ->
                visibility.updateVisibility {
                    it.onErrorShow(R.drawable.ic_server_error)
                }
            else ->
                visibility.updateVisibility {
                    it.onErrorShow(R.drawable.ic_server_error)
                }
        }
    }

    private fun showMessageGetExtensionMap(message: Message) {
        when(message) {
            Message.NETWORK_ERROR ->
                showMessageEvent.value = "네트워크 오류가 발생했습니다"
            Message.SERVER_ERROR ->
                showMessageEvent.value = "서버 오류가 발생했습니다"
            Message.UNKNOW_ERROR ->
                showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
            else ->
                showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

    private fun onErrorGetExtensionMapIsNull(result: Result.Error<Map>) {
        showMessageGetExtensionMap(result.message)
        visibility.updateVisibility {
            it.visibleLoad = View.GONE
            it.visibleError = View.VISIBLE
        }
        showImageGetExtensionMap(result.message)
    }

    private fun createRoomModel(): RoomModel =
        RoomModel(
            time = selectedClock.value!!,
            classNum = selectedClassNum.value!!
        )

    private fun createExtensionInfoModel(): ExtensionInfoModel =
        ExtensionInfoModel(
            classNum = selectedClassNum.value!!,
            seatNum = selectedSeatNum.value!!,
            time = selectedClock.value!!
        )

    private fun checkGetExtensionMapInput(): Boolean =
        selectedClock.value.isNotNull() and
                selectedClassNum.value.isNotNull()

    private fun checkApplyExtensionInput(): Boolean =
        checkGetExtensionMapInput() and
                selectedSeatNum.value.isNotNull()

}
