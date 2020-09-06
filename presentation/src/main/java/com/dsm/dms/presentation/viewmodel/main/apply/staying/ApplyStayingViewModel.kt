package com.dsm.dms.presentation.viewmodel.main.apply.staying

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.enums.StayInfo
import com.dsm.dms.domain.usecase.ApplyStayUseCase
import com.dsm.dms.domain.usecase.GetStayInfoUseCase
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import io.reactivex.observers.DisposableSingleObserver

class ApplyStayingViewModel(
    private val getStayInfoUseCase: GetStayInfoUseCase,
    private val applyStayingUseCase: ApplyStayUseCase
): BaseViewModel() {
    val nowStayingState = MutableLiveData<String>()

    val cardChangeColorEvent = SingleLiveEvent<String>()
    val backToMainEvent = SingleLiveEvent<Unit>()
    val showMessageEvent = SingleLiveEvent<String>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> getStayInfo()
        }
    }

    fun fridayGoClick() {
        applyStay("금요귀가")
    }

    fun saturdayGoClick() {
        applyStay("토요귀가")
    }

    fun saturdayBackClick() {
        applyStay("토요귀사")
    }

    fun stayingClick() {
        applyStay("잔류")
    }

    fun backClick() = backToMainEvent.call()

    private fun applyStay(cardText: String) {
        val stayInfo = when(cardText) {
            "잔류" -> StayInfo.STAY
            "토요귀가" -> StayInfo.SATURDAY_GO
            "토요귀사" -> StayInfo.SATURDAY_BACK
            "금요귀가" -> StayInfo.FRIDAY_GO
            else -> StayInfo.STAY
        }
        applyStayingUseCase.execute(stayInfo, object: DisposableSingleObserver<Result<Unit>>() {
            override fun onSuccess(result: Result<Unit>) {
                when(result) {
                    is Result.Success -> onSuccessApplyStay(result, cardText)
                    is Result.Error -> onErrorApplyStay(result)
                }
            }

            override fun onError(e: Throwable) {

            }
        })
    }

    private fun getStayInfo() {
        getStayInfoUseCase.execute(Unit, object: DisposableSingleObserver<Result<StayInfo>>() {
            override fun onSuccess(result: Result<StayInfo>) {
                when(result) {
                    is Result.Success -> onSuccessGetStayInfo(result)
                    is Result.Error -> onErrorGetStayInfo(result)
                }
            }

            override fun onError(e: Throwable) {

            }
        })
    }

    private fun onSuccessGetStayInfo(result: Result.Success<StayInfo>) {
        setCardChangeColorFromResult(result.data)
    }

    private fun onErrorGetStayInfo(result: Result.Error<StayInfo>) {
        if (result.data != null) {
            setCardChangeColorFromResult(result.data!!)
        }
        when(result.message) {
            Message.NETWORK_ERROR -> showMessageEvent.value = "네트워크 오류가 발생했습니다"
            Message.SERVER_ERROR -> showMessageEvent.value = "서버 오류가 발생했습니다"
            Message.UNKNOW_ERROR -> showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
            else -> showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

    private fun setCardChangeColorFromResult(stayInfo: StayInfo) {
        when(stayInfo) {
            StayInfo.FRIDAY_GO -> cardChangeColorEvent.value = "금요귀가"
            StayInfo.SATURDAY_BACK -> cardChangeColorEvent.value = "토요귀사"
            StayInfo.SATURDAY_GO -> cardChangeColorEvent.value = "토요귀가"
            StayInfo.STAY -> cardChangeColorEvent.value = "잔류"
        }
    }

    private fun onSuccessApplyStay(result: Result.Success<Unit>, cardText: String) {
        showMessageEvent.value = "잔류 신청이 완료되었습니다"
        cardChangeColorEvent.value = cardText
    }

    private fun onErrorApplyStay(result: Result.Error<Unit>) {
        when(result.message) {
            Message.NETWORK_ERROR -> showMessageEvent.value = "네트워크 오류가 발생했습니다"
            Message.SERVER_ERROR -> showMessageEvent.value = "서버 오류가 발생했습니다"
            Message.UNKNOW_ERROR -> showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
            else -> showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

}
