package com.dsm.dms.domain.service

import com.dsm.dms.domain.BaseTest
import com.dsm.dms.domain.base.ErrorHandler
import com.dsm.dms.domain.base.Message
import com.dsm.dms.domain.base.Result
import com.dsm.dms.domain.entity.Auth
import com.dsm.dms.domain.`object`.ChangePassword
import com.dsm.dms.domain.`object`.SignUpObject
import com.dsm.dms.domain.`object`.VerificationKey
import com.dsm.dms.domain.entity.Token
import com.dsm.dms.domain.repository.AccountRepository
import com.dsm.dms.domain.usecase.*
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`


class AccountServiceTest: BaseTest() {

    @Mock
    private lateinit var accountRepository: AccountRepository
    @Mock
    private lateinit var errorHandler: ErrorHandler

    private lateinit var accountService: AccountService

    private lateinit var signInUseCase: SignInUseCase
    private lateinit var signUpUseCase: SignUpUseCase
    private lateinit var changePasswordUseCase: ChangePasswordUseCase
    private lateinit var temporaryPasswordUseCase: TemporaryPasswordUseCase
    private lateinit var verifyCertificationCodeUseCase: VerifyCertificationCodeUseCase

    @Before
    fun init() {

        accountService = AccountServiceImpl(accountRepository, errorHandler)

        signInUseCase = SignInUseCase(accountService, CompositeDisposable())
        signUpUseCase = SignUpUseCase(accountService, CompositeDisposable())
        changePasswordUseCase = ChangePasswordUseCase(accountService, CompositeDisposable())
        temporaryPasswordUseCase = TemporaryPasswordUseCase(accountService, CompositeDisposable())
        verifyCertificationCodeUseCase = VerifyCertificationCodeUseCase(accountService, CompositeDisposable())
    }

    @Test
    fun `로그인 성공 테스트`() {

        val auth = Auth(
            id = "asd",
            password = "123",
            email = "asd@gmail.com"
        )
        val token = "1F34a423R532"

        `when`(accountRepository.signIn(auth))
            .thenReturn(
                Single.just(
                    Token(
                        accessToken = token,
                        refreshToken = token
                    )
                )
            )

        signInUseCase.create(auth)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `로그인 실패 테스트`() {

        val exception = Exception()
        val auth = Auth(
            id = "asd",
            password = "123",
            email = "asd@gmail.com"
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(accountRepository.signIn(auth))
            .thenReturn(
                Single.error(exception)
            )

        signInUseCase.create(auth)
            .test().assertValue(
                Result.Error(message = Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `회원가입 성공 테스트`() {

        val signUpObject =
            SignUpObject(
                Auth(
                    id = "asd",
                    password = "123",
                    email = "asd@gmail.com"
                ),
                VerificationKey(
                    "sqaddsd231"
                )
            )

        `when`(accountRepository.signUp(signUpObject))
            .thenReturn(
                Completable.complete()
            )

        signUpUseCase.create(signUpObject)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `회원가입 실패 테스트`() {

        val exception = Exception()
        val signUpObject =
            SignUpObject(
                Auth(
                    id = "asd",
                    password = "123",
                    email = "asd@gmail.com"
                ),
                VerificationKey(
                    "sqaddsd231"
                )
            )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(accountRepository.signUp(signUpObject))
            .thenReturn(
                Completable.error(exception)
            )

        signUpUseCase.create(signUpObject)
            .test().assertValue(
                Result.Error(message = Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `비밀번호 변경 성공 테스트`() {

        val password = "123"
        val changePassword = ChangePassword(
            currentPassword = password,
            newPassword = password
        )

        `when`(accountRepository.changePassword(changePassword))
            .thenReturn(
                Completable.complete()
            )

        changePasswordUseCase.create(changePassword)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `비밀번호 변경 실패 테스트`() {

        val exception = Exception()
        val password = "123"
        val changePassword = ChangePassword(
            currentPassword = password,
            newPassword = password
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(accountRepository.changePassword(changePassword))
            .thenReturn(
                Completable.error(exception)
            )

        changePasswordUseCase.create(changePassword)
            .test().assertValue(
                Result.Error(message = Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `임시 비밀번호 발급 성공 테스트`() {

        val auth = Auth(
            id = "asd",
            password = "123",
            email = "asd@gmail.com"
        )

        `when`(accountRepository.temporaryPassword(auth))
            .thenReturn(
                Completable.complete()
            )

        temporaryPasswordUseCase.create(auth)
            .test().assertValue(
                Result.Success(Unit)
            )

    }

    @Test
    fun `임시 비밀번호 발급 실패 테스트`() {

        val exception = Exception()
        val auth = Auth(
            id = "asd",
            password = "123",
            email = "asd@gmail.com"
        )

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(accountRepository.temporaryPassword(auth))
            .thenReturn(
                Completable.error(exception)
            )

        temporaryPasswordUseCase.create(auth)
            .test().assertValue(
                Result.Error(message = Message.UNKNOW_ERROR)
            )

    }

    @Test
    fun `확인코드 인증하기 성공 테스트`() {
        val certificationCode = "43253"
        val verificationKey = VerificationKey("sqaddsd231")

        `when`(accountRepository.verifyCertificationCode(certificationCode))
            .thenReturn(
                Single.just(verificationKey)
            )

        verifyCertificationCodeUseCase.create(certificationCode)
            .test().assertValue(
                Result.Success(verificationKey)
            )

    }

    @Test
    fun `확인코드 인증하기 실패 테스트`() {
        val exception = Exception()
        val certificationCode = "43253"

        `when`(errorHandler.errorHandle(exception))
            .thenReturn(Message.UNKNOW_ERROR)

        `when`(accountRepository.verifyCertificationCode(certificationCode))
            .thenReturn(
                Single.error(exception)
            )

        verifyCertificationCodeUseCase.create(certificationCode)
            .test().assertValue(
                Result.Error(message = Message.UNKNOW_ERROR)
            )

    }

}
