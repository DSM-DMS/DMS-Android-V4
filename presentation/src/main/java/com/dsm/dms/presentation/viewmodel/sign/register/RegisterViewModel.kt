package com.dsm.dms.presentation.viewmodel.sign.register

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.dsm.dms.domain.`object`.VerificationKey
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.usecase.SignUpUseCase
import com.dsm.dms.domain.usecase.VerifyCertificationCodeUseCase
import com.dsm.dms.presentation.base.BaseViewModel
import com.dsm.dms.presentation.base.SingleLiveEvent
import com.dsm.dms.presentation.isNotNullOrBlank
import com.dsm.dms.presentation.model.*
import io.reactivex.observers.DisposableSingleObserver


class RegisterViewModel(
    private val signUpUseCase: SignUpUseCase,
    private val verifyCertificationCodeUseCase: VerifyCertificationCodeUseCase
): BaseViewModel() {
    val backEvent = SingleLiveEvent<Unit>()
    val nextEvent = SingleLiveEvent<Unit>()
    val completeEvent = SingleLiveEvent<Unit>()
    val showMessageEvent = SingleLiveEvent<String>()
    val onVerifyLoadingEvent = SingleLiveEvent<String>()
    val onVerifySuccessEvent = SingleLiveEvent<String>()
    val onVerifyErrorEvent = SingleLiveEvent<String>()


    val idData = MutableLiveData<String>()
    val passwordData = MutableLiveData<String>()
    val retryPasswordData = MutableLiveData<String>()
    val certificationCodeData = MutableLiveData<String>()
    val verificationKeyData = MutableLiveData<String>()
    val nowStateLabelData = MutableLiveData<String>()

    override fun apply(event: Lifecycle.Event) {

    }

    fun backClick() {
        backEvent.call()
    }

    fun nextClick() {
        when(nowStateLabelData.value) {
            "CreateAccount" -> {
                if (checkSignUpInput()) {
                    if (checkRetryPassword()) {
                        createAccount()
                    } else {
                        showMessageEvent.value = "비밀번호가 서로 다릅니다"
                    }
                } else {
                    showMessageEvent.value = "계정정보를 모두 입력해주세요"
                }
            }
            "CertifyAccount" -> {
                if (verificationKeyData.value.isNotNullOrBlank())
                    nextEvent.call()
                else
                    showMessageEvent.value = "확인코드를 인증해주세요"
            }
        }
    }

    fun completeClick() {
        completeEvent.call()
    }

    fun verifyClick() {
        onVerifyLoadingEvent.value = "인증 중"
        if (checkCertificationCodeInput()) {
            verifyCertificationCode()
        } else {
            onVerifyErrorEvent.value = "인증 오류"
            showMessageEvent.value = "확인코드를 입력해주세요"
        }
    }

    private fun verifyCertificationCode() {
        verifyCertificationCodeUseCase.execute(
            certificationCodeData.value!!, object: DisposableSingleObserver<Result<VerificationKey>>() {
                override fun onSuccess(result: Result<VerificationKey>) {
                    when(result) {
                        is Result.Success -> onSuccessVerifyCertificationCode(result)
                        is Result.Error -> onErrorVerifyCertificationCode(result)
                    }
                }

                override fun onError(e: Throwable) {

                }

            }
        )
    }

    private fun onSuccessVerifyCertificationCode(result: Result.Success<VerificationKey>) {
        verificationKeyData.value = result.data.verificationKey
        onVerifySuccessEvent.value = "인증 성공"
    }

    private fun onErrorVerifyCertificationCode(result: Result.Error<VerificationKey>) {
        onVerifyErrorEvent.value = "인증 오류"
        when(result.message) {
            Message.UNKNOW_ERROR ->
                showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
            Message.SERVER_ERROR ->
                showMessageEvent.value = "서버 오류가 발생했습니다"
            Message.NETWORK_ERROR ->
                showMessageEvent.value = "네트워크 오류가 발생했습니다"
            else ->
                showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

    private fun createAccount() {
        signUpUseCase.execute(createSignUpModel().toObject(), object: DisposableSingleObserver<Result<Unit>>() {
            override fun onSuccess(result: Result<Unit>) {
                when(result) {
                    is Result.Success -> onSuccessCreateAccount(result)
                    is Result.Error -> onErrorCreateAccount(result)
                }

            }

            override fun onError(e: Throwable) {
                showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
            }

        })
    }

    private fun onSuccessCreateAccount(result: Result.Success<Unit>) {
        nextEvent.call()
    }

    private fun onErrorCreateAccount(result: Result.Error<Unit>) {
        when(result.message) {
            Message.UNKNOW_ERROR ->
                showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
            Message.SERVER_ERROR ->
                showMessageEvent.value = "서버 오류가 발생했습니다"
            Message.NETWORK_ERROR ->
                showMessageEvent.value = "네트워크 오류가 발생했습니다"
            else ->
                showMessageEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

    private fun checkCertificationCodeInput(): Boolean =
        certificationCodeData.value.isNotNullOrBlank()

    private fun checkSignUpInput(): Boolean =
        idData.value.isNotNullOrBlank() and
                passwordData.value.isNotNullOrBlank() and
                retryPasswordData.value.isNotNullOrBlank() and
                (retryPasswordData.value == passwordData.value)

    private fun checkRetryPassword(): Boolean =
        passwordData.value == retryPasswordData.value

    private fun createSignUpModel(): SignUpModel =
        SignUpModel(
            AuthModel(
                id = idData.value!!,
                password = passwordData.value!!,
                email = ""
            ),
            createVerificationKeyModel()
        )

    private fun createVerificationKeyModel(): VerificationKeyModel =
        VerificationKeyModel(
            verificationKeyData.value!!
        )

}
