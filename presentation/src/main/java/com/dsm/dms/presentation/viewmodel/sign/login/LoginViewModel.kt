package com.dsm.dms.presentation.viewmodel.sign.login

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.usecase.SignInUseCase
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.isNotNullOrBlank
import com.dsm.dms.presentation.model.AuthModel
import com.dsm.dms.presentation.model.toEntity
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.PublishSubject

class LoginViewModel(
    private val signInUseCase: SignInUseCase
) : BaseViewModel() {
    val loginEvent = SingleLiveEvent<Unit>()
    val registerEvent = SingleLiveEvent<Unit>()
    val onLoadEvent = SingleLiveEvent<String>()
    val onErrorEvent = SingleLiveEvent<String>()
    val onSuccessEvent = SingleLiveEvent<String>()

    val idData = MutableLiveData<String>()
    val passwordData = MutableLiveData<String>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun loginClick() {
        onLoadEvent.value = "로그인 중"
        if (checkSignInInput()) {
            signIn()
        } else {
            onErrorEvent.value = "아이디와 비밀번호를 입력해주세요"
        }
    }

    fun registerClick() {
        registerEvent.call()
    }

    private fun signIn() {
        signInUseCase.execute(
            createAuthModel().toEntity(), object: DisposableSingleObserver<Result<Unit>>() {
                override fun onSuccess(result: Result<Unit>) {
                    when(result) {
                        is Result.Success -> onSuccessSignIn(result)
                        is Result.Error -> onErrorSignIn(result)
                    }
                }
                override fun onError(e: Throwable) {
                    onErrorEvent.value = "알 수 없는 오류가 발생했습니다"
                }
            }
        )
    }

    private fun onSuccessSignIn(result: Result.Success<Unit>) {
        onSuccessEvent.value = "로그인 성공"
        loginEvent.call()
    }

    private fun onErrorSignIn(result: Result.Error<Unit>) {
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

    private fun createAuthModel(): AuthModel =
        AuthModel(
            idData.value!!,
            passwordData.value!!,
            ""
        )

    private fun checkSignInInput(): Boolean =
        idData.value.isNotNullOrBlank() and
                passwordData.value.isNotNullOrBlank()

}
