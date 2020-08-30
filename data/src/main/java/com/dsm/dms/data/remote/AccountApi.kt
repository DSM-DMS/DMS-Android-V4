package com.dsm.dms.data.remote

import com.dsm.dms.data.dto.request.SignInRequest
import com.dsm.dms.data.dto.request.SignUpRequest
import com.dsm.dms.data.dto.request.TemporaryPasswordRequest
import com.dsm.dms.data.entity.ChangePasswordData
import com.dsm.dms.data.entity.TokenData
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST


interface AccountApi {

    @POST("auth")
    fun signIn(@Body body: SignInRequest): Single<TokenData>

    @POST("signup")
    fun signUp(@Body body: SignUpRequest): Completable

    @PATCH("password")
    fun changePassword(@Body body: ChangePasswordData): Completable

    @POST("password")
    fun requestTemporaryPassword(@Body body: TemporaryPasswordRequest): Completable

}
