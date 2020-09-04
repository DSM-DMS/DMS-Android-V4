package com.dsm.dms.data.remote

import com.dsm.dms.data.dto.request.SignInRequest
import com.dsm.dms.data.dto.request.SignUpRequest
import com.dsm.dms.data.dto.request.TemporaryPasswordRequest
import com.dsm.dms.data.`object`.ChangePasswordData
import com.dsm.dms.data.`object`.VerificationKeyData
import com.dsm.dms.data.dto.request.VerifyCertificationCodeRequest
import com.dsm.dms.data.entity.TokenData
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*


interface AccountApi {

    @POST("auth")
    fun signIn(@Body body: SignInRequest): Single<TokenData>

    @POST("signup")
    fun signUp(@Header("VerificationCode") verificationKey: String, @Body body: SignUpRequest): Completable

    // 임시
    @POST("verify")
    fun verifyCertificationCode(@Body body: VerifyCertificationCodeRequest): Single<VerificationKeyData>

    @PATCH("password")
    fun changePassword(@Body body: ChangePasswordData): Completable

    @POST("password")
    fun requestTemporaryPassword(@Body body: TemporaryPasswordRequest): Completable

}
