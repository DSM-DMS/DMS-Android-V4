package com.dsm.dms.presentation.viewmodel.main.mypage.etc.change

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.usecase.ChangePasswordUseCase
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.bindingAdapter.ViewPagerItem
import com.dsm.dms.presentation.isNotNullOrBlank
import com.dsm.dms.presentation.model.ChangePasswordModel
import com.dsm.dms.presentation.model.toEntity
import io.reactivex.observers.DisposableSingleObserver


class ChangePasswordViewModel(
    private val changePasswordUseCase: ChangePasswordUseCase
): BaseViewModel() {

    val originPassword = MutableLiveData<String>()
    val newPassword = MutableLiveData<String>()
    val newPasswordCheck = MutableLiveData<String>()

    val backToMyPageEvent = SingleLiveEvent<Unit>()
    val onLoadEvent = SingleLiveEvent<String>()
    val onErrorEvent = SingleLiveEvent<String>()
    val onSuccessEvent = SingleLiveEvent<String>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun backClick() = backToMyPageEvent.call()

    fun clickChange() {
        onLoadEvent.value = "비밀번호 변경 중"
        if (checkChangePasswordInput()) {
            if (checkRetryPassword()) {
                changePassword()
            } else {
                onErrorEvent.value = "비밀번호가 서로 다릅니다"
            }
        } else {
            onErrorEvent.value = "정보를 모두 입력해주세요"
        }
    }

    private fun changePassword() {
        changePasswordUseCase.execute(
            createChangePasswordModel().toEntity(), object : DisposableSingleObserver<Result<Unit>>() {
                override fun onSuccess(result: Result<Unit>) {
                    when(result) {
                        is Result.Success -> onSuccessChangePassword(result)
                        is Result.Error -> onErrorChangePassword(result)
                    }
                }

                override fun onError(e: Throwable) {

                }
            }
        )
    }

    private fun onSuccessChangePassword(result: Result.Success<Unit>) {
        onSuccessEvent.value = "비밀번호가 변경 되었습니다"
    }

    private fun onErrorChangePassword(result: Result.Error<Unit>) {
        when(result.message) {
            Message.UNKNOW_ERROR -> onErrorEvent.value = "알 수 없는 오류가 발생했습니다"
            Message.NETWORK_ERROR -> onErrorEvent.value = "네트워크 오류가 발생했습니다"
            Message.SERVER_ERROR -> onErrorEvent.value = "서버 오류가 발생했습니다"
            else -> onErrorEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

    private fun createChangePasswordModel(): ChangePasswordModel =
        ChangePasswordModel(
            originPassword.value!!,
            newPassword.value!!
        )

    private fun checkChangePasswordInput(): Boolean =
        originPassword.value.isNotNullOrBlank()
            .and(newPassword.value.isNotNullOrBlank())
            .and(newPasswordCheck.value.isNotNullOrBlank())

    private fun checkRetryPassword(): Boolean =
        newPassword.value == newPasswordCheck.value

}
